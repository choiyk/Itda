package com.kyung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.kyung.dto.Meeting;
import com.kyung.dto.MyArticleByUser;
import com.kyung.dto.MyCommentByUser;
import com.kyung.dto.MyMeetingByUser;
/*import com.kyung.dto.MyMeetingByUser;
>>>>>>> refs/heads/choiyk2*/
import com.kyung.dto.User;
import com.kyung.dto.UserJoinedMeetings;
import com.kyung.mapper.UserMapper;
import com.kyung.model.FindPwModel;
import com.kyung.model.ResultModel;
import com.kyung.model.UserRegistrationModel;
import com.kyung.utils.Encryption;

@Service
public class UserService {
	@Autowired UserMapper userMapper;

	public List<Meeting> MeetingsOfMyComment(int userId)
	{
		List<Meeting> meetings = userMapper.MeetingsOfMyComment(userId);
		return meetings;
	}

	public List<MyCommentByUser> MyCommentByUser(int userId)
	{
		List<MyCommentByUser> myComments = userMapper.myCommentByUser(userId);
		return myComments;
	}

	public List<Meeting> MeetingsOfMyArticle(int userId)
	{
		List<Meeting> meetings = userMapper.MeetingsOfMyArticle(userId);
		return meetings;
	}

	public List<MyArticleByUser> MyArticleByUser(int userId)
	{
		List<MyArticleByUser> myArticles = userMapper.myArticleByUser(userId);
		return myArticles;
	}

	public List<MyMeetingByUser> myMeetingByUser(int userId)
	{
		System.out.println("userId : "+userId);
		List<MyMeetingByUser> myMeetings = userMapper.myMeetingByUser(userId);
		return myMeetings;
	}

	public List<UserJoinedMeetings> userJoinMeetings(int userId)
	{
		List<UserJoinedMeetings> list=userMapper.userJoinMeetings(userId);
		//test
		//for(Meeting m : list) System.out.println(m.);
		return list;
	}

	public boolean passwordComparisonEdit(String pw1, String pw2, BindingResult bindingResult)
	{
		if(pw1.equals(pw2) == false)
		{
			bindingResult.rejectValue("password2", null, "비밀번호가 일치하지 않습니다.");
			return false;
		}

		return true;
	}

	public boolean passwordComparison(String pw1, String pw2, BindingResult bindingResult)
	{
		if(pw1.equals(pw2) == false)
		{
			bindingResult.rejectValue("password", null, "비밀번호가 일치하지 않습니다.");
			return false;
		}

		return true;
	}

	public User getCurrentUser()
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication instanceof UserAuthenticationProvider.UserAuthentication)
			return ((UserAuthenticationProvider.UserAuthentication)authentication).getUser();
		return null;
	}

	public static void setCurrentUser(User user)
	{
		((UserAuthenticationProvider.UserAuthentication)SecurityContextHolder.getContext()
				.getAuthentication()).setUser(user);
	}

	public boolean hasErrors(UserRegistrationModel userModel, BindingResult bindingResult)
	{
		if(bindingResult.hasErrors())
		{
			return true;
		}

		if(userModel.getPassword1().equals(userModel.getPassword2())==false)
		{
			bindingResult.rejectValue("password2", null, "비밀번호가 일치하지 않습니다.");
			return true;
		}

		User user = userMapper.findByStudentNumber(userModel.getStudentNumber());

		if(user != null)
		{
			bindingResult.rejectValue("studentNumber", null, "학번이 중복됩니다.");
			return true;
		}

		return false;
	}

	public boolean hasErrors(FindPwModel findPwModel, BindingResult bindingResult){

		if(bindingResult.hasErrors()){
			return true;
		}

		if(findPwModel.getStudentNumber()==null || findPwModel.getStudentNumber().equals("")){
			bindingResult.rejectValue("studentNumber", null, "학번을 입력해주세요.");
		}

		if(findPwModel.getAnswer()==null || findPwModel.getAnswer().equals("")){
			bindingResult.rejectValue("answer", null, "답변을 입력해주세요.");
		}

		return false;

	}

	public User login(String loginId, String password) {
		User user = userMapper.findByStudentNumber(loginId);
		//System.out.println(user.getStudentNumber());

		if(user == null) {
			return null;
		}
		String pw = Encryption.encrypt(password, Encryption.SHA256);
		if(user.getPassword().equals(pw) == false)
		{
			System.out.println("불일치");
			return null;
		}
		System.out.println("일치");
		return user;
	}
	/*
	public void join(User user) {
		String password = Encryption.encrypt(user.getPassword(), Encryption.SHA256);
		user.setPassword(password);
		userMapper.insert(user);
	}*/

	public void join(UserRegistrationModel userModel) {
		User user = userModel.toUser();
		String password = Encryption.encrypt(user.getPassword(), Encryption.SHA256);

		user.setPassword(password);
		user.setType(2); // 2: user
		if(user.getNickname() == "")
			user.setNickname(user.getName());

		userMapper.insert(user);
	}

	public List<User> findAll()
	{
		List<User> users = userMapper.findAll();
		return users;
	}

	public User findOne(int id) {
		User user = userMapper.findOne(id);
		return user;
	}

	public User findByStudentNumber(String studentNumber)
	{
		User user = userMapper.findByStudentNumber(studentNumber);
		return user;
	}

	public User findByName(String name)
	{
		User user = userMapper.findByName(name);
		return user;
	}

	public void create(User user)
	{
		userMapper.insert(user);
	}

	public void delete(int id)
	{
		userMapper.delete(id);
	}

	public void update(User user)
	{
		userMapper.update(user);
	}

	public void edit(User user)
	{
		userMapper.edit(user);
	}

	public void pwUpdate(User user,String password)
	{
		System.out.println("pwUpdate:"+password);
		password = Encryption.encrypt(password, Encryption.SHA256);
		String studentNumber = user.getStudentNumber();
		System.out.println("pwUpdate:"+password+" "+studentNumber);
		userMapper.pwUpdate(password, studentNumber);
	}

	public ResultModel findPw(FindPwModel findPwModel){

		User find = findByStudentNumber(findPwModel.getStudentNumber());

		if(find==null){
			return new ResultModel(false, "존재하지 않는 회원입니다.");
		}

		else if(findPwModel.getQuestion()!=Integer.parseInt(find.getQuestion()) || !findPwModel.getAnswer().equals(find.getAnswer())){
			return new ResultModel(false, "질문에 답이 틀립니다.");
		}

		else return new ResultModel(true,find.getStudentNumber());

	}


}
