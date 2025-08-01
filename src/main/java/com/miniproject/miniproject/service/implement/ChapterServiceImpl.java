package com.miniproject.miniproject.service.implement;

import com.miniproject.miniproject.dto.Request.ChapterRequest;
import com.miniproject.miniproject.dto.Response.ApiResponse;
import com.miniproject.miniproject.dto.Response.Chapter.ChapterDetailResponse;
import com.miniproject.miniproject.dto.Response.Chapter.ChapterResponse;
import com.miniproject.miniproject.exception.AccessDeniedException;
import com.miniproject.miniproject.exception.ResourceNotFoundException;
import com.miniproject.miniproject.model.Chapter;
import com.miniproject.miniproject.model.Publisher;
import com.miniproject.miniproject.model.Mapper.Chapter.ChapterDetailMapper;
import com.miniproject.miniproject.model.Mapper.Chapter.ChapterMapper;
import com.miniproject.miniproject.repository.*;
import com.miniproject.miniproject.service.ChapterService;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ChapterServiceImpl implements ChapterService {
    private final PublisherRepository publisherRepository;
    private final ChapterRepository chapterRepository;
    private final ChapterMapper chapterMapper;
    private final ChapterDetailMapper chapterDetailMapper;

    @Override
    public List<ChapterResponse> getAllChapter() {
        return chapterRepository.findAll().stream()
                .map(chapterMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ApiResponse<ChapterDetailResponse> getChapterById(String chapterId) {
        Chapter result = chapterRepository.findById(chapterId)
                .orElseThrow(() -> new ResourceNotFoundException("Can't found Chapter with id =" + chapterId));

        return new ApiResponse<>("Success", chapterDetailMapper.toDTO(result));
    }

    @Override
    public ChapterResponse addChapter(ChapterRequest request, String userId, String previousChapterId) {
        Publisher publisher = (Publisher) publisherRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Can't found Publisher"));
        Chapter chapter = mapToEntity(request);
        chapter.setPrevious_chapter(previousChapterId);
        Chapter saved = chapterRepository.save(chapter);
        return chapterMapper.toDTO(saved);
    }

    @Override
    public ChapterResponse updateChapter(ChapterRequest request, String chapterId) {
        if (chapterRepository.existsById(chapterId)) {
            Chapter c = mapToEntity(request);
            Chapter updated = chapterRepository.save(c);
            return chapterMapper.toDTO(updated);
        } else
            throw new ResourceNotFoundException("Chapter not found");
    }

    @Override
    public void deleteChapter(String chapterId, String currentUserId) {
        Chapter c = chapterRepository.findById(chapterId)
                .orElseThrow(() -> new ResourceNotFoundException("Chapter not found!"));
        if (!c.getBook().getPublisher().getId().equals(currentUserId)) {
            throw new AccessDeniedException("You don't have permission to delete this Chapter");
        }
        chapterRepository.deleteById(chapterId);
    }

    // maping entity
    private Chapter mapToEntity(ChapterRequest request) {
        Chapter b = new Chapter();
        b.setChapter_name(request.getChapter_name());
        b.setPublish_at(request.getPublish_at());
        b.setType(request.getType());
        return b;
    }
}
