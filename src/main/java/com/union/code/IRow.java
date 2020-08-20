package com.union.code;

import java.sql.ResultSet;
import java.util.List;

public interface IRow<T> {
    public <T> T mapping(ResultSet resultSet);
}
