package com.example.demo.repoitory;

import com.example.demo.Users;
import org.springframework.data.jpa.repository.*;

import java.util.List;

public interface UsersRepository extends JpaRepository<Users, Long> {
    List<Users> findAllByName(String name);//просто правильное название метода даст возможность
    //избежать запросов на SQL

    @Query("select u from Users u where u.email like '%@gmail.com%'")//если этого мало можно написать HQL
        //собственный запрос на языке похожем на SQL
    List<Users> findWhereEmailIsGmail();

    @Query(value = "select * from users where name like '%smith%'", nativeQuery = true)
        //если и этого мало - можно написать запрос на чистом SQL и все это будет работать
    List<Users> findWhereNameStartsFromSmith();

}