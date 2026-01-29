package com.skillgap.skillgap_navigator.dto;

public class SkillDTO {

    private Long id;
    private String name;
    private String category;

    // ✅ REQUIRED for JSON deserialization (POST requests)
    public SkillDTO() {
    }

    // ✅ Used for responses (GET requests)
    public SkillDTO(Long id, String name, String category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }

    // ===== GETTERS =====
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    // ===== SETTERS =====
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
