package com.duruijuan.service;

import com.duruijuan.pojo.Stu;

/**
 * @projectName: food
 * @package: com.duruijuan
 * @className: StuService
 * @author: duruijuan
 * @description:
 * @since: 2024-01-09 20:52
 * @version: 1.0
 */
public interface StuService {
    /**
     * description:获取学生信息
     * @param id
     * @return {@link Stu}
     * @author: duruijuan
     * @since: 2024-01-09 20:58
     **/
     Stu getStuInfo(int id);
     /**
      * description:保存学生信息
      * @param
      * @return
      * @author: duruijuan
      * @since: 2024-01-09 20:58
      **/
     void saveStu();
     /**
      * description:更新学生信息
      * @param id
      * @return
      * @author: duruijuan
      * @since: 2024-01-09 20:59
      **/
     void updateStu(int id);
     /**
      * description:删除学生信息
      * @param id
      * @return
      * @author: duruijuan
      * @since: 2024-01-09 20:59
      **/
   void deleteStu(int id);
    public void saveParent();
    public void saveChildren();

}
