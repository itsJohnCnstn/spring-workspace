package com.johncnstn.userservice.dto;

import java.io.Serializable;

public record OrderDTO(Long id, String name, String category, String color, double price) implements Serializable {
}