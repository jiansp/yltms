package com.haoche.yltms.system.service.impl;

import com.haoche.yltms.system.model.InventoryInfo;
import com.haoche.yltms.system.model.Shop;
import com.haoche.yltms.system.model.User;
import com.haoche.yltms.system.model.Vehicle;
import com.haoche.yltms.system.repository.InventoryRepository;
import com.haoche.yltms.system.repository.ShopRepository;
import com.haoche.yltms.system.repository.VehicleRepository;
import com.haoche.yltms.system.service.InventoryService;
import com.haoche.yltms.system.vo.TableData;
import com.haoche.yltms.utils.CopyUtils;
import com.haoche.yltms.utils.UUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class InventoryServiceImpl implements InventoryService {
    @Autowired
    private InventoryRepository inventoryRepository;
    @Autowired
    private ShopRepository shopRepository;
    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public TableData findInventorys(Integer pageNo, Integer limit, Map<String, String> params) {
        String shopId = params.get("shopId");
        Specification<InventoryInfo> specification = (Specification<InventoryInfo>) (root, criteriaQuery, criteriaBuilder) -> {
            Path<String> isDelete = root.get("isDelete");
            Predicate p1 = criteriaBuilder.isNull(isDelete);
            Predicate p3 = criteriaBuilder.notEqual(isDelete, "1");
            Predicate p = criteriaBuilder.or(p1, p3);
            if (!StringUtils.isEmpty(shopId)) {
                Shop shop = this.shopRepository.getOne(shopId);
                Path<Shop> shopPath = root.get("shop");
                Predicate p2 = criteriaBuilder.equal(shopPath, shop);
                return criteriaBuilder.and(p, p2);
            }
            return p;
        };
        Sort sort = new Sort(Sort.DEFAULT_DIRECTION, "createTime");
        PageRequest pageable = PageRequest.of(pageNo - 1, limit, sort);
        Page<InventoryInfo> page = this.inventoryRepository.findAll(specification, pageable);
        TableData tableData = new TableData();
        List<Vehicle> inventoryInfos = new ArrayList<>();
        for (int i = 0; i < page.getContent().size(); i++) {
            InventoryInfo inventoryInfo = page.getContent().get(i);
            inventoryInfo.getVehicle().setAmount(inventoryInfo.getAmount());
            inventoryInfos.add(inventoryInfo.getVehicle());
        }
        tableData.setData(inventoryInfos);
        tableData.setCount(page.getTotalElements());
        return tableData;
    }

    @Override
    public void saveAndUpdate(InventoryInfo inventoryInfo, User user) {
        Date now = new Date();
        List<InventoryInfo> inventoryInfos = this.inventoryRepository.findByShopAndVehicle(inventoryInfo.getShopId(),inventoryInfo.getVehicleId());
        if(inventoryInfos != null && inventoryInfos.size()>0){
            InventoryInfo old = inventoryInfos.get(0);
            inventoryInfo.setModifier(user.getId());
            inventoryInfo.setModifyTime(now);
            Integer amount = Integer.valueOf(inventoryInfo.getAmount()) + Integer.valueOf(old.getAmount());
            inventoryInfo.setAmount(String.valueOf(amount));
            CopyUtils.copyProperties(inventoryInfo, old);
            this.inventoryRepository.save(old);
        }else{
            inventoryInfo.setVehicle(this.vehicleRepository.getOne(inventoryInfo.getVehicleId()));
            inventoryInfo.setShop(this.shopRepository.getOne(inventoryInfo.getShopId()));

            if (StringUtils.isEmpty(inventoryInfo.getId())) {
                inventoryInfo.setId(UUIDGenerator.getUUID());
                inventoryInfo.setCreateTime(now);
                inventoryInfo.setCreator(user.getId());
                this.inventoryRepository.save(inventoryInfo);
            } else {
                this.update(inventoryInfo,user);

            }
        }

    }

    @Override
    public InventoryInfo findInventory(String shopId, String vehicleId) {
        List<InventoryInfo> list = this.inventoryRepository.findByShopAndVehicle(shopId,vehicleId);
        if(list!=null && list.size()>0){
            return list.get(0);
        }else{
            return null;
        }
    }

    @Override
    public void updateAmount(String shopId, String vehicleId, int n) {
        List<InventoryInfo> list = this.inventoryRepository.findByShopAndVehicle(shopId,vehicleId);
        if(list!=null && list.size()>0){
            InventoryInfo inventoryInfo =  list.get(0);
            inventoryInfo.setAmount(String.valueOf(Integer.valueOf(inventoryInfo.getAmount()) + n));
            this.inventoryRepository.save(inventoryInfo);
        }else{
            throw new RuntimeException("未找到库存，请先为门店分配车辆");
        }
    }

    @Override
    public void update(InventoryInfo inventoryInfo,User user) {
        Date now = new Date();
        InventoryInfo old = this.inventoryRepository.getOne(inventoryInfo.getId());
        inventoryInfo.setModifier(user.getId());
        inventoryInfo.setModifyTime(now);
        CopyUtils.copyProperties(inventoryInfo, old);
        this.inventoryRepository.save(old);

    }
}
