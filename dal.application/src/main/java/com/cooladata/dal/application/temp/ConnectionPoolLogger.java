package com.cooladata.dal.application.temp;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.mchange.v2.c3p0.ConnectionCustomizer;

@Component
public class ConnectionPoolLogger implements ConnectionCustomizer{

    private static final Logger logger = Logger
            .getLogger(ConnectionPoolLogger.class);
    private int activeConnections = 0;
    private int acquiredConnections = 0;

    @Override
    public void onAcquire(java.sql.Connection arg0, String arg1)
			throws Exception {
        logger.info("onAcquire: Connection acquired from database : " + arg0
                + " [" + arg1 + "]");
        acquiredConnections++;
        logger.info("onAcquire: Total Open Connections in Pool : " + acquiredConnections);
    }
    @Override
	public void onDestroy(java.sql.Connection arg0, String arg1)
			throws Exception {
        logger.info("onDestroy: Connection closed with database : " + arg0 + " ["
                + arg1 + "]");
        acquiredConnections--;
        logger.info("onDestroy: Total Open Connections in Pool : " + acquiredConnections);

    }

    
	@Override
	public void onCheckOut(java.sql.Connection arg0, String arg1)
			throws Exception {
        logger.info("onCheckOut: Connection from pool provide to application : "
                + arg0 + " [" + arg1 + "]");
        activeConnections++;
        logger.info("onCheckOut: Total Active Connections in Pool : " + activeConnections);
    }
    @Override
    public void onCheckIn(java.sql.Connection arg0, String arg1)
			throws Exception {
        logger.info("onCheckIn: Connection returned to pool from application : "
                + arg0 + " [" + arg1 + "]");
        activeConnections--;
        logger.info("onCheckIn: Total Active Connections in Pool : " + activeConnections);

    }


}
