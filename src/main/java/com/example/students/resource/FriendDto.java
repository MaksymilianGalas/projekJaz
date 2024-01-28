package com.example.students.resource;

import com.example.students.data.Friends;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FriendDto {

    @NonNull
    private UUID id;
    @NotBlank
    private String name;
    @Email
    private String email;
    private String phoneNumber;
    private String address;


}
