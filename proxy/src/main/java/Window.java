import java.util.List;

public class Window {
    final ArticleService articleService;
    Window(ArticleService articleService){
        this.articleService=articleService;
    }
    List<Article> articles;
    Article article;
    List<String> commants;
    void getArticles(String keyword){
        articles=articleService.searchArticle(keyword);
    }
    void pickArticle(String articleId){
        article=articles.stream().filter(article -> article.id == articleId).findFirst().get();
    }
    void getComments(){
        commants=articleService.getComments(article.id);
    }

}
