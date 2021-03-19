/*
 * Copyright (c) 2021, salesforce.com, inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.salesforce.cdp.queryservice.core;

import java.sql.*;

public class QueryServiceStatement extends QueryServiceAbstractStatement implements Statement {

    public QueryServiceStatement(QueryServiceConnection queryServiceConnection,
                                 int resultSetType, int resultSetConcurrency) {
        super(queryServiceConnection, resultSetType, resultSetConcurrency);
    }

    @Override
    public ResultSet executeQuery(String sql) throws SQLException {
        resultSet = super.executeQuery(sql);
        return resultSet;
    }

    @Override
    public int executeUpdate(String sql) throws SQLException {
        throw new SQLFeatureNotSupportedException("Write is not supported in query service");
    }

    @Override
    public void close() throws SQLException {
        //NOOP
    }

    @Override
    public int getMaxFieldSize() throws SQLException {
        return 0;
    }

    @Override
    public void setMaxFieldSize(int max) throws SQLException {
        //NOOP
    }

    @Override
    public int getMaxRows() throws SQLException {
        //TODO: Check if this needs to be 4999
        return 0;
    }

    @Override
    public void setMaxRows(int max) throws SQLException {
        //NOOP
    }

    @Override
    public void setEscapeProcessing(boolean enable) throws SQLException {
        //NOOP
    }

    @Override
    public int getQueryTimeout() throws SQLException {
        //TODO: Check if there needs to be any timeout set
        return 0;
    }

    @Override
    public void setQueryTimeout(int seconds) throws SQLException {
        //NOOP
    }

    @Override
    public void cancel() throws SQLException {
        //TODO: Check if http client request can be cancelled
    }

    @Override
    public SQLWarning getWarnings() throws SQLException {
        return null;
    }

    @Override
    public void clearWarnings() throws SQLException {
        //NOOP
    }

    @Override
    public void setCursorName(String name) throws SQLException {
        //NOOP
    }

    @Override
    public boolean execute(String sql) throws SQLException {
       resultSet = super.executeQuery(sql);
       return true;
    }

    @Override
    public ResultSet getResultSet() throws SQLException {
        return resultSet;
    }

    @Override
    public int getUpdateCount() throws SQLException {
        return 0;
    }

    @Override
    public boolean getMoreResults() throws SQLException {
        //TODO implement pagination once supported.
        return false;
    }

    @Override
    public void setFetchDirection(int direction) throws SQLException {
        //NOOP
    }

    @Override
    public int getFetchDirection() throws SQLException {
        return ResultSet.FETCH_FORWARD;
    }

    @Override
    public void setFetchSize(int rows) throws SQLException {
        //NOOP
    }

    @Override
    public int getFetchSize() throws SQLException {
        return 0;
    }

    @Override
    public int getResultSetConcurrency() throws SQLException {
        return 0;
    }

    @Override
    public int getResultSetType() throws SQLException {
        return 0;
    }

    @Override
    public void addBatch(String sql) throws SQLException {
        throw new SQLFeatureNotSupportedException("Batch execution is not supported");
    }

    @Override
    public void clearBatch() throws SQLException {
        //NOOP
    }

    @Override
    public int[] executeBatch() throws SQLException {
        throw new SQLFeatureNotSupportedException("Batch execution is not supported");
    }

    @Override
    public Connection getConnection() throws SQLException {
        return connection;
    }

    @Override
    public boolean getMoreResults(int current) throws SQLException {
        return false;
    }

    @Override
    public ResultSet getGeneratedKeys() throws SQLException {
        return null;
    }

    @Override
    public int executeUpdate(String sql, int autoGeneratedKeys) throws SQLException {
        throw new SQLFeatureNotSupportedException("Write is not supported for query service");
    }

    @Override
    public int executeUpdate(String sql, int[] columnIndexes) throws SQLException {
        throw new SQLFeatureNotSupportedException("Write is not supported for query service");
    }

    @Override
    public int executeUpdate(String sql, String[] columnNames) throws SQLException {
        throw new SQLFeatureNotSupportedException("Write is not supported for query service");
    }

    @Override
    public boolean execute(String sql, int autoGeneratedKeys) throws SQLException {
        return false;
    }

    @Override
    public boolean execute(String sql, int[] columnIndexes) throws SQLException {
        return false;
    }

    @Override
    public boolean execute(String sql, String[] columnNames) throws SQLException {
        return false;
    }

    @Override
    public int getResultSetHoldability() throws SQLException {
        return 0;
    }

    @Override
    public boolean isClosed() throws SQLException {
        return false;
    }

    @Override
    public void setPoolable(boolean poolable) throws SQLException {
        //NOOP
    }

    @Override
    public boolean isPoolable() throws SQLException {
        return false;
    }

    @Override
    public void closeOnCompletion() throws SQLException {
        //NOOP
    }

    @Override
    public boolean isCloseOnCompletion() throws SQLException {
        return false;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }
}
