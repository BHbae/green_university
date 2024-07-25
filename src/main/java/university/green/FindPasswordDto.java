package university.green;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class FindPasswordDto {

	
	private String name;
	private Integer id;
	private String email;
	private String userRole;
	
}
