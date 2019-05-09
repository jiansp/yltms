package com.haoche.yltms.system.service.impl;

import com.haoche.yltms.system.repository.OrderRepository;
import com.haoche.yltms.system.service.StatisticsService;
import com.haoche.yltms.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class StatisticsServiceImpl implements StatisticsService {
    @Autowired
    private OrderRepository orderRepository;

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    private List presList(List<Map> list){
        List<List> result = new ArrayList<>();
        List<String> names = new ArrayList<>();
        for (Map map : list) {
            names.add((String) map.get("name"));
        }
        result.add(names);
        result.add(list);
        return result;
    }

    @Override
    public List findVehicleFreq() {
        List<Map> list = this.orderRepository.findVehicleFreq();
        return presList(list);
    }

    @Override
    public List findShopFreq() {
        List<Map> list = this.orderRepository.findShopFreq();
        return presList(list);
    }

    @Override
    public List findFreq() {
        String sd = sdf.format(DateUtils.getBeginDayOfLastWeek());
        String ed = sdf.format(DateUtils.getEndDayOfLastWeek());
        List<Map> list = this.orderRepository.findFreq(sd, ed);
        return presList(list);
    }

    @Override
    public List findIncome() {
        String sd = sdf.format(DateUtils.getBeginDayOfLastWeek());
        String ed = sdf.format(DateUtils.getEndDayOfLastWeek());
        List<Map> list = this.orderRepository.findIncome(sd, ed);
        return presList(list);
    }
}
