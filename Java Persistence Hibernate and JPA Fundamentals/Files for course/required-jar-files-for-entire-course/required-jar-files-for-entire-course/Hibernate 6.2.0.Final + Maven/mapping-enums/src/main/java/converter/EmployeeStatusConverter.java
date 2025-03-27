package converter;

import enums.EmployeeStatus;
import jakarta.persistence.AttributeConverter;

public class EmployeeStatusConverter implements AttributeConverter<EmployeeStatus, Integer>{

	public Integer convertToDatabaseColumn(EmployeeStatus attr) {
        if (attr == null) { 
            return null;
        }
        switch (attr) {
            case FULL_TIME:
                return 100;
            case PART_TIME:
                return 200;
            case CONTRACT:
                return 300;
            default:
                throw new IllegalArgumentException("The " + attr + " not supported.");
        }
	}

	public EmployeeStatus convertToEntityAttribute(Integer dbData) {
        if (dbData == null) {
            return null;
        }
        switch (dbData) {
            case 100:
                return EmployeeStatus.FULL_TIME;
            case 200:
                return EmployeeStatus.PART_TIME;
            case 300:
                return EmployeeStatus.CONTRACT;
            default:
                throw new IllegalArgumentException("The " + dbData + " not supported.");
        }
	}

}
