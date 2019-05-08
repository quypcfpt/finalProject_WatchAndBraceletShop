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
    @Query(nativeQuery = true, value =
            "Select  " +
                    "Count(Distinct od.ProductId) " +
                    "FROM " +
                    "[Order] o, OrderDetail od" +
                    "WHERE "+
                    ":startDate <= o.CreateDateTime and o.CreateDateTime <= :endDate" +
                    "    and od.OrderId = o.Id")
    int CountSoldProduct(@Param("startDate") Date startDate, @Param("endDate")Date endDate);
}
