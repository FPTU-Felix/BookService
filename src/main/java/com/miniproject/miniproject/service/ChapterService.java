package com.miniproject.miniproject.service;

import com.miniproject.miniproject.dto.Request.ChapterRequest;
import com.miniproject.miniproject.dto.Response.ApiResponse;
import com.miniproject.miniproject.dto.Response.Chapter.ChapterDetailResponse;
import com.miniproject.miniproject.dto.Response.Chapter.ChapterResponse;

import java.util.List;

public interface ChapterService {
    List<ChapterResponse> getAllChapter();

    ApiResponse<ChapterDetailResponse> getChapterById(String chapterId);

    ChapterResponse addChapter(ChapterRequest request, String userId, String previousChapterId);

    ChapterResponse updateChapter(ChapterRequest request, String chapterId);

    void deleteChapter(String chapterId, String currentUserId);
}
