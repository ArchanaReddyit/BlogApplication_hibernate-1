package dao;

import java.util.List;
import model.Blog;

public interface BlogDaoInterface {
	void insertBlog(Blog blog);
	Blog selectBlog(int blogId);
	List<Blog> selectALLBlogs();
	void deleteBlog(int id);
	void updateBlog(Blog blog);
	

}
