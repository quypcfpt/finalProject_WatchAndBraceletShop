package com.spring2019.repository;

import com.spring2019.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer> {
    Orders findById(int id);

    List<Orders> findAllByStatus(int status);

    @Query(value =
            "Select  " +
                    "Count(o) " +
                    "FROM " +
                    "Orders o " +
                    "WHERE " +
                    ":startDate <= o.createDateTime and o.createDateTime <= :endDate")
    int countOrder(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

    @Query(value =
            "Select  " +
                    "Count(o) " +
                    "FROM " +
                    "Orders o " +
                    "WHERE " +
                    ":startDate <= o.createDateTime and o.createDateTime <= :endDate" +
                    "  and o.status = :status")
    int CountOrderStatus(@Param("startDate") Date startDate, @Param("endDate")Date endDate, @Param("status") int status);

}
