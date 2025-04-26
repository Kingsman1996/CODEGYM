package com.model;
import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Tên bài hát không được để trống")
    @Size(max = 800, message = "Tên bài hát không được vượt quá 800 ký tự")
    @Pattern(regexp = "^[^@;,.=+\\-]*$", message = "Tên bài hát không được chứa ký tự đặc biệt như @ ; , . = - +")
    private String name;

    @NotBlank(message = "Nghệ sĩ thể hiện không được để trống")
    @Size(max = 300, message = "Nghệ sĩ không được vượt quá 300 ký tự")
    @Pattern(regexp = "^[^@;,.=+\\-]*$", message = "Nghệ sĩ không được chứa ký tự đặc biệt như @ ; , . = - +")
    private String artist;

    @NotBlank(message = "Thể loại không được để trống")
    @Size(max = 1000, message = "Thể loại không được vượt quá 1000 ký tự")
    @Pattern(regexp = "^[a-zA-Z0-9, ]*$", message = "Thể loại chỉ được chứa chữ, số và dấu phẩy")
    private String genre;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
