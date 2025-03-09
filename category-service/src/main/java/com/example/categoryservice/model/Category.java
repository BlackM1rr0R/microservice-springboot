package com.example.categoryservice.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "all_categories")
@Getter
@Setter
public class Category {
    @Id
    private String id;
    private String categoryname;
    private List<String> subCategoryIds;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }
    public List<String> getSubCategoryIds() {
        return subCategoryIds;
    }

    public void setSubCategoryIds(List<String> subCategoryIds) {
        this.subCategoryIds = subCategoryIds;
    }

}
