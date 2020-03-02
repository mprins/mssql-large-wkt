package org.example;

import java.sql.SQLException;
import com.microsoft.sqlserver.jdbc.Geometry;

import org.locationtech.jts.io.ParseException;

public class MsSqlJdbcConverter extends GeometryJdbcConverter {

    @Override
    public Object convertToNativeGeometryObject(org.locationtech.jts.geom.Geometry g, int srid) throws SQLException, ParseException {
        if (g == null) {
            return null;
        }
        String param = g.toText();

        if (param == null || param.trim().length() == 0) {
            return null;
        }
//        System.out.println("Converted geom WKT: " + param + ", SRID: " + srid);
        Geometry sqlGeom = Geometry.STGeomFromText(param, srid);
//        System.out.println("mssql geom: " + sqlGeom);
        return sqlGeom;
    }
}
