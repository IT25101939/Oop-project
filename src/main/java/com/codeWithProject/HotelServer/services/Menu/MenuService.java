package com.codeWithProject.HotelServer.services.Menu;

import com.codeWithProject.HotelServer.entity.MenuItem;
import com.codeWithProject.HotelServer.enums.MenuCategory;
import com.codeWithProject.HotelServer.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

    // CREATE
    public MenuItem addMenuItem(MenuItem item) {
        return menuRepository.save(item);
    }

    // READ ALL
    public List<MenuItem> getAllItems() {
        return menuRepository.findAll();
    }

    // READ BY CATEGORY
    public List<MenuItem> getByCategory(MenuCategory category) {
        return menuRepository.findByCategory(category);
    }

    // UPDATE
    public MenuItem updateMenuItem(Long id, MenuItem updatedItem) {
        MenuItem item = menuRepository.findById(id).orElse(null);

        if (item != null) {
            item.setName(updatedItem.getName());
            item.setPrice(updatedItem.getPrice());
            item.setCategory(updatedItem.getCategory());
            return menuRepository.save(item);
        }
        return null;
    }

    // DELETE
    public void deleteMenuItem(Long id) {
        menuRepository.deleteById(id);
    }
}
