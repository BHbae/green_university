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
public class FindIdDto {

	
	private String name;
	private String email;
	private String userRole;
	
}
