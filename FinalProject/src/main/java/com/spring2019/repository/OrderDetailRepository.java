package com.spring2019.repository;

import com.spring2019.entity.OrderDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail,Integer> {
    OrderDetail findById(int id);
    @Query(value =
            "Select  " +
                    "Count(Distinct od.productById) " +
                    "FROM " +
                    "Orders o, OrderDetail od " +
                    "WHERE "+
                    ":startDate <= o.createDateTime and o.createDateTime <= :endDate" +
                    "    and od.orderById = o.id")
    int CountSoldProduct(@Param("startDate") Date startDate, @Param("endDate")Date endDate);

    @Query(value =
            "Select  " +
                    "SUM(od.price) " +
                    "FROM " +
                    "Orders o, OrderDetail od " +
                    "WHERE "+
                    ":startDate <= o.createDateTime and o.createDateTime <= :endDate" +
                    "    and od.orderById = o.id")
    int CountTotalPrice(@Param("startDate") Date startDate, @Param("endDate")Date endDate);
}
