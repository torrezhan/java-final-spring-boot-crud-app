package com.example.demo.service;

import com.example.demo.model.Resource;
import com.example.demo.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResourceService {

    @Autowired
    private ResourceRepository resourceRepository;

    // Сохранение нового ресурса
    public Resource saveResource(Resource resource) {
        return resourceRepository.save(resource);
    }

    // Получение всех ресурсов
    public List<Resource> getAllResources() {
        return resourceRepository.findAll();
    }

    // Обновление существующего ресурса
    public Resource updateResource(Long id, Resource resource) {
        if (resourceRepository.existsById(id)) {
            resource.setId(id); // Устанавливаем id ресурса для обновления
            return resourceRepository.save(resource);
        } else {
            throw new RuntimeException("Resource not found");
        }
    }

    // Удаление ресурса
    public void deleteResource(Long id) {
        if (resourceRepository.existsById(id)) {
            resourceRepository.deleteById(id);
        } else {
            throw new RuntimeException("Resource not found");
        }
    }
}
