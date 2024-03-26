package com.board.projectboard.service;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.then;

import com.board.projectboard.domain.Article;
import com.board.projectboard.domain.ArticleComment;
import com.board.projectboard.dto.ArticleCommentDto;
import com.board.projectboard.repository.ArticleCommentRepository;
import com.board.projectboard.repository.ArticleRepository;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@DisplayName("비즈니스 로직 - 댓글")
@ExtendWith(MockitoExtension.class)
class ArticleCommentServiceTest {

    @InjectMocks private ArticleCommentService sut;

    @Mock private ArticleRepository articleRepository;
    @Mock private ArticleCommentRepository articleCommentRepository;

    @DisplayName("게시글 아이디로 조회하면, 댓글리스트를 반환한다.")
    @Test
    void givenArticleId_whenSearchingComments_thenReturnsComments() {
        //given
        Long articleId = 1L;
        BDDMockito.given(articleRepository.findById(articleId)).willReturn(Optional.of(Article.of("title", "content", "#java")));

        //when
        List<ArticleCommentDto> articleComments = sut.searchArticleComment(articleId);

        //then
        assertThat(articleComments).isNotNull();
        then(articleRepository).should().findById(articleId);
    }

    @DisplayName("댓글 정보를 입력하면, 댓글을 저장한다")
    @Test
    void givenArticleCommentInfo_whenSearchingComments_thenReturnsComments() {
        //given
        Long articleId = 1L;
        BDDMockito.given(articleRepository.findById(articleId)).willReturn(Optional.of(Article.of("title", "content", "#java")));

        //when
        List<ArticleCommentDto> articleComments = sut.searchArticleComment(articleId);

        //then
        assertThat(articleComments).isNotNull();
        then(articleRepository).should().findById(articleId);
    }
}