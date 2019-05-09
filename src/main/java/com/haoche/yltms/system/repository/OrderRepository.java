package com.haoche.yltms.system.repository;

import com.haoche.yltms.system.model.RentOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface OrderRepository extends JpaRepository<RentOrder, String>, JpaSpecificationExecutor<RentOrder> {

    @Query(value = "from RentOrder where user.id =:userId order by createTime desc ")
    List<RentOrder> findOrders(@Param("userId") String userId);

    @Query(value = "select t.amount value ,v.model name from vehicle v inner join (select count(vehicle_id) amount,vehicle_id from rent_order where order_status = '3' group by vehicle_id) t on t.vehicle_id = v.id", nativeQuery = true)
    List<Map> findVehicleFreq();

    @Query(value = "select count(OBTAIN_SHOP) value,OBTAIN_SHOP name from rent_order where order_status = '3' group by OBTAIN_SHOP", nativeQuery = true)
    List<Map> findShopFreq();

    @Query(value = "SELECT CASE DAYOFWEEK(t2.all_day) WHEN 1 THEN '星期日' WHEN 2 THEN '星期一' WHEN 3 THEN '星期二' WHEN 4 THEN '星期三' WHEN 5 THEN '星期四' WHEN 6 THEN '星期五' WHEN 7 THEN '星期六' END AS `name`, COUNT(o.cost_rent) AS `value` FROM ( SELECT @rownum \\:= @rownum + 1 AS NO , DATE_ADD(:startDate, INTERVAL @rownum DAY) AS all_day FROM ( SELECT @rownum \\:= -1 ) r_init, USER ) t2 LEFT JOIN rent_order o ON t2.all_day = DATE(o.obtain_time) and o.order_status = '3' WHERE t2.all_day >= :startDate AND t2.all_day <= :endDate  GROUP BY t2.all_day ORDER BY t2.all_day", nativeQuery = true)
    List<Map> findFreq(@Param("startDate") String startDate, @Param("endDate") String endDate);

    @Query(value = "SELECT CASE DAYOFWEEK(t2.all_day) WHEN 1 THEN '星期日' WHEN 2 THEN '星期一' WHEN 3 THEN '星期二' WHEN 4 THEN '星期三' WHEN 5 THEN '星期四' WHEN 6 THEN '星期五' WHEN 7 THEN '星期六' END AS `name`, IFNULL(SUM(o.cost_rent), 0) AS `value` FROM ( SELECT @rownum \\:= @rownum + 1 AS NO , DATE_ADD(:startDate, INTERVAL @rownum DAY) AS all_day FROM ( SELECT @rownum \\:= -1 ) r_init, USER ) t2 LEFT JOIN rent_order o ON t2.all_day = DATE(o.obtain_time) and o.order_status = '3' WHERE t2.all_day >= :startDate AND t2.all_day <= :endDate  GROUP BY t2.all_day ORDER BY t2.all_day", nativeQuery = true)
    List<Map> findIncome(@Param("startDate") String startDate, @Param("endDate") String endDate);

}
