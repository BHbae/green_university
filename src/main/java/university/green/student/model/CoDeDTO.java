package university.green.student.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CoDeDTO {
	
	private int deptid;  
	private String deptname;
	private int collegeid;  
	private String collegename;
	
}
