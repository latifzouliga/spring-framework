package com.cydeo.repository;

import com.cydeo.entity.Account;
import com.cydeo.enums.UserRole;
import com.sun.xml.bind.v2.TODO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to list all accounts with a specific country or state
    List<Account> getAccountByCountryOrState(String country,String state);
    @Query("SELECT a FROM Account a WHERE a.country = :country or a.state = :state")
    List<Account> getAccountByCountryOrStateJPQL(@Param("country") String country, @Param("state") String state);
    @Query(value = "SELECT * FROM account_details WHERE country = ?1 or state =  ?2", nativeQuery = true)
    List<Account> getAccountByCountryOrStateSQL(String country, String state);



    //Write a derived query to list all accounts with age lower than or equal to a specific value
    List<Account> getAccountByAgeLessThanEqual(Integer age);
    @Query("SELECT a FROM Account a WHERE a.age <= :age")
    List<Account> getAccountByAgeLessThanEqualJPQL(@Param("age") Integer age);
    @Query(value = "SELECT * FROM account_details WHERE age <= ?1", nativeQuery = true)
    List<Account> getAccountByAgeLessThanEqualSQL(Integer age);

    //Write a derived query to list all accounts with a specific role
    List<Account> getAccountByRole(Enum<UserRole> role);
    @Query("SELECT a FROM Account a WHERE a.role = :role")
    List<Account> getAccountByRoleJPQL(@Param("role") Enum<UserRole> role);


    //Write a derived query to list all accounts between a range of ages
    List<Account> getAccountByAgeBetween(Integer age1, Integer age2);
    @Query("SELECT a FROM Account a where a.age between ?1 AND ?2")
    List<Account> allAccountsBetween(Integer age1, Integer age2);

    @Query(value = "SELECT * FROM account_details WHERE age BETWEEN :age1 AND :age2",nativeQuery = true)
    List<Account> accountsBetweenAges(@Param("age1") Integer age1, @Param("age2") Integer age2);

//TODO: ========================================================================================

    //Write a derived query to list all accounts where the beginning of the address contains the keyword
    List<Account> getAccountByAddressStartsWith(String pattern);
    @Query("SELECT a FROM Account a WHERE a.address LIKE concat(?1,'%') ")
    List<Account> getAccountByAddressStartsWithJPQL(String pattern);

    @Query(value = "SELECT * FROM account_details WHERE address LIKE CONCAT(?1,'%')",nativeQuery = true)
    List<Account> getAccountByAddressStartsWithSQL(String pattern);

    @Query(value = "SELECT * FROM account_details WHERE address LIKE CONCAT(:pattern,'%')",nativeQuery = true)
    List<Account> getAccountByAddressStartsWithSQLNamedQ(@Param("pattern") String pattern);



    //Write a derived query to sort the list of accounts with age
    List<Account> getAccountsByOrderByAge();
    List<Account> getAccountsByOrderByAgeDesc();

    @Query("SELECT a FROM Account a ORDER BY a.age")
    List<Account> findAllOrderByAge();
    @Query(value = "SELECT * FROM account_details ORDER BY age desc ",nativeQuery = true)
    List<Account> findAllSortByAgeDesc();
    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns all accounts
    @Query("SELECT a FROM Account a")
    List<Account> getAllAccounts();
    List<Account> findAllBy();

    //Write a JPQL query to list all admin accounts
    @Query("SELECT a FROM Account a WHERE a.role = 'ADMIN'")
    List<Account> getAdminAccounts();

    @Query(value = "SELECT * FROM account_details WHERE role LIKE 'USER'",nativeQuery = true)
    List<Account> getAdminAccountsSQL();

    List<Account> findAllByRole(UserRole role);

    //Write a JPQL query to sort all accounts with age
    @Query("SELECT a FROM Account a ORDER BY a.age")
    List<Account> getAccountsSortedByAge();

    // ------------------- Native QUERIES ------------------- //

    //Write a native query to read all accounts with an age lower than a specific value

    @Query(value = "SELECT * FROM account_details where age <= ?1",nativeQuery = true)
    List<Account> getAllAccountsLessThan(Integer age);
    @Query("SELECT a FROM Account a WHERE a.age < :age")
    List<Account> getAllAccountsLessThanJPQL(@Param("age") Integer age);

    List<Account> getAccountsByAgeLessThan(Integer age);


    //Write a native query to read all accounts that a specific value can be containable in the name, address, country, state city
    @Query(value = "SELECT * FROM account_details WHERE " +
            "name       like concat('%',?1,'%') " +
            "or address like concat('%',?1,'%') " +
            "or country like concat('%',?1,'%') " +
            "or state   like concat('%',?1,'%')",nativeQuery = true)
    List<Account> getAccountContains(String pattern);

    @Query("SELECT a FROM Account a WHERE " +
            "a.name       LIKE '%' || :pattern || '%' " +
            "OR a.address LIKE '%' || :pattern || '%' " +
            "OR a.city    LIKE '%' || :pattern || '%' " +
            "OR a.country LIKE '%' || :pattern || '%' " +
            "OR a.state   LIKE '%' || :pattern || '%' "  )
    List<Account> getAccountContainsJPQL(@Param("pattern") String pattern);


    //Write a native query to read all accounts with an age greater than a specific value

    @Query(value = "SELECT * FROM account_details WHERE age >= :age",nativeQuery = true)
    List<Account> getAccountsAgeGreaterThan(@Param("age") Integer age);




}
