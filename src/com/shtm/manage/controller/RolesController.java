package com.shtm.manage.controller;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shtm.controller.BaseController;
import com.shtm.manage.groups.RolesGroups.DeleteRoleGroups;
import com.shtm.manage.groups.RolesGroups.InsertRoleGroups;
import com.shtm.manage.groups.RolesGroups.SelectRolesDatagridGroups;
import com.shtm.manage.groups.RolesGroups.UpdateRoleGroups;
import com.shtm.manage.groups.RolesGroups.UpdateRolePermission;
import com.shtm.manage.po.AdminsReplier;
import com.shtm.manage.po.RolesReceiver;
import com.shtm.manage.service.RolesServiceI;


/**
 * Title:RolesController
 * <p>
 * Description:roles的controller
 * <p>
 * @author Kor_Zhang
 * @date 2017年10月2日 上午11:28:41
 * @version 1.0
 */
@RequestMapping("/roles")
@Scope("prototype")
@Controller
public class RolesController extends BaseController<RolesServiceI> {

	
	/**
	 * Title:
	 * <p>
	 * Description:更新roles的權限;
	 * <p>
	 * @author Kor_Zhang
	 * @date 2017年10月2日 上午11:29:31
	 * @version 1.0
	 * @param receiver
	 * @param result
	 * @return
	 * @throws Exception
	 */
	@RequiresAuthentication
	@RequiresPermissions("roles:update")
	@RequestMapping("/updateRolePermission")
	public @ResponseBody AdminsReplier updateRolePermission(
			@Validated(value = { UpdateRolePermission.class }) @RequestBody RolesReceiver receiver,
			BindingResult result) throws Exception {
		AdminsReplier replier = new AdminsReplier();
		try {
			getError(result);

			service.updateRolePermission(receiver.getId(),receiver.getPermissionsIds());

			replier.setResult(RESULT.TRUE);
			replier.setMsg("更新角色權限成功");
		} catch (Exception e) {
			e.printStackTrace();
			replier.setResult(RESULT.FALSE);
			replier.setMsg(e.getMessage());
		}
		return replier;
	}
	
	/**
	 * 
	 * Title:
	 * <p>
	 * Description:添加角色成功
	 * <p>
	 * @author Kor_Zhang
	 * @date 2017年10月2日 下午1:23:45
	 * @version 1.0
	 * @param receiver
	 * @param result
	 * @return
	 * @throws Exception
	 */
	@RequiresAuthentication
	@RequiresPermissions("roles:insert")
	@RequestMapping("/insertRole")
	public @ResponseBody AdminsReplier insertRole(
			@Validated(value = { InsertRoleGroups.class }) @RequestBody RolesReceiver receiver,
			BindingResult result) throws Exception {
		AdminsReplier replier = new AdminsReplier();
		try {
			getError(result);

			service.insertRoleGroups(receiver);

			replier.setResult(RESULT.TRUE);
			replier.setMsg("添加角色成功");
		} catch (Exception e) {
			e.printStackTrace();
			replier.setResult(RESULT.FALSE);
			replier.setMsg(e.getMessage());
		}
		return replier;
	}
	/**
	 * 
	 * Title:
	 * <p>
	 * Description:添加角色成功
	 * <p>
	 * @author Kor_Zhang
	 * @date 2017年10月2日 下午1:23:45
	 * @version 1.0
	 * @param receiver
	 * @param result
	 * @return
	 * @throws Exception
	 */
	@RequiresAuthentication
	@RequiresPermissions("roles:delete")
	@RequestMapping("/deleteRole")
	public @ResponseBody AdminsReplier deleteRole(
			@Validated(value = { DeleteRoleGroups.class }) @RequestBody RolesReceiver receiver,
			BindingResult result) throws Exception {
		AdminsReplier replier = new AdminsReplier();
		try {
			getError(result);

			service.deleteRole(receiver);

			replier.setResult(RESULT.TRUE);
			replier.setMsg("删除角色成功");
		} catch (Exception e) {
			e.printStackTrace();
			replier.setResult(RESULT.FALSE);
			replier.setMsg(e.getMessage());
		}
		return replier;
	}
	/**
	 * Title:
	 * <p>
	 * Description:查询easyui所需的分页数据;
	 * <p>
	 * @author Kor_Zhang
	 * @date 2017年10月2日 下午1:26:56
	 * @version 1.0
	 * @param receiver
	 * @param result
	 * @return
	 * @throws Exception
	 */
	@RequiresAuthentication
	@RequiresPermissions("roles:select")
	@RequestMapping("/selectRolesDatagrid")
	public @ResponseBody AdminsReplier selectRolesDatagrid(
			@Validated(value = { SelectRolesDatagridGroups.class }) @RequestBody RolesReceiver receiver,
			BindingResult result) throws Exception {
		AdminsReplier replier = new AdminsReplier();
		try {
			getError(result);

			service.selectRolesDatagrid(receiver);

			replier.setResult(RESULT.TRUE);
			replier.setMsg("查询角色成功");
		} catch (Exception e) {
			e.printStackTrace();
			replier.setResult(RESULT.FALSE);
			replier.setMsg(e.getMessage());
		}
		return replier;
	}
	/**
	 * Title:
	 * <p>
	 * Description:更新角色基本信息;
	 * <p>
	 * @author Kor_Zhang
	 * @date 2017年10月2日 下午1:27:28
	 * @version 1.0
	 * @param receiver
	 * @param result
	 * @return
	 * @throws Exception
	 */
	@RequiresAuthentication
	@RequiresPermissions("roles:update")
	@RequestMapping("/updateRole")
	public @ResponseBody AdminsReplier updateRole(
			@Validated(value = { UpdateRoleGroups.class }) @RequestBody RolesReceiver receiver,
			BindingResult result) throws Exception {
		AdminsReplier replier = new AdminsReplier();
		try {
			getError(result);

			service.updateRole(receiver);

			replier.setResult(RESULT.TRUE);
			replier.setMsg("更新角色成功");
		} catch (Exception e) {
			e.printStackTrace();
			replier.setResult(RESULT.FALSE);
			replier.setMsg(e.getMessage());
		}
		return replier;
	}

}