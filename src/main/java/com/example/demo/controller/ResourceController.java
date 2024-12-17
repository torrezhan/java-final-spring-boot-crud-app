package com.example.demo.controller;

import com.example.demo.model.Resource;
import com.example.demo.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resources")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    // POST: Создание нового ресурса
    @PostMapping
    public Resource createResource(@RequestBody Resource resource) {
        return resourceService.saveResource(resource);
    }

    // GET: Получение списка всех ресурсов
    @GetMapping
    public List<Resource> getAllResources() {
        return resourceService.getAllResources();
    }

    // PUT: Обновление существующего ресурса
    @PutMapping("/{id}")
    public Resource updateResource(@PathVariable Long id, @RequestBody Resource resource) {
        return resourceService.updateResource(id, resource);
    }

    // DELETE: Удаление ресурса по id
    @DeleteMapping("/{id}")
    public void deleteResource(@PathVariable Long id) {
        resourceService.deleteResource(id);
    }
}
