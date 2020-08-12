package tk.lens.solution.web.webflux.model;

import java.io.Serializable;

import javax.persistence.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Entity
@Data
@NoArgsConstructor
public class FooBar implements Serializable{

	private String name;
}
