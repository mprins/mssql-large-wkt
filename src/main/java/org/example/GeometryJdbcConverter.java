package org.example;

import org.locationtech.jts.io.ParseException;

import java.sql.SQLException;

public abstract class GeometryJdbcConverter {
    abstract Object convertToNativeGeometryObject(org.locationtech.jts.geom.Geometry g, int srid) throws SQLException, ParseException;
}
