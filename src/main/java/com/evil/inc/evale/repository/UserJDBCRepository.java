package com.evil.inc.evale.repository;

import com.evil.inc.evale.domain.Assessment;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserJDBCRepository {
    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<String> findAllUserEmails(){
        return jdbcTemplate.queryForList("select u.email from users u", String.class);
    }


    public List<String> findAllUserEmailsByUserNames(List<String> usernames){
        String sql = "select u.email from users u where username in (:usernames)";
        SqlParameterSource namedParameters = new MapSqlParameterSource("usernames", usernames);
        return this.namedParameterJdbcTemplate.queryForList(sql, namedParameters, String.class);
    }
}
