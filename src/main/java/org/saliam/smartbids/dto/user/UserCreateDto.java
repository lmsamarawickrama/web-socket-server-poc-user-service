package org.saliam.smartbids.dto.user;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter @Setter
public class UserCreateDto
{
  private String username;

  private String email;

  private String password;

  private Set<RoleDto> roles;
}
