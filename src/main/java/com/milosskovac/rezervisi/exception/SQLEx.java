package com.milosskovac.rezervisi.exception;

import java.sql.SQLException;

public class SQLEx extends SQLException {
    public SQLEx() {
        super();
    }

    public SQLEx(String message) {
        super(message);
    }
}
