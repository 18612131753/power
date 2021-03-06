package com.ray.power.user.service;

import com.ray.base.util.GridDataModel;
import com.ray.power.user.form.UserForm;
import com.ray.power.user.model.UserDO;
import com.ray.power.user.model.UserGridModelVO;

public interface UserService {

	public GridDataModel<UserGridModelVO>  query(UserForm queryForm);
	
	public UserDO findUserById( Integer userid );
	
	public int saveUser(UserDO user) throws Exception;
	
	/** 停用用户 */
	public void stopUser(Integer userid,Integer updateuserid) throws Exception ;
	
	public void updateUser(UserDO user) throws Exception ;
}
