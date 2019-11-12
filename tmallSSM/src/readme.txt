查询
1. 首先浏览器上访问路径 /admin_category_list
2. tomcat根据web.xml上的配置信息，拦截到了/admin_category_list，并将其交由DispatcherServlet处理。
3. DispatcherServlet 根据springMVC的配置，将这次请求交由CategoryController类进行处理，所以需要进行这个类的实例化
4. 在实例化CategoryController的时候，注入CategoryServiceImpl
5. 在实例化CategoryServiceImpl的时候，又注入CategoryMapper
6. 根据ApplicationContext.xml中的配置信息，将CategoryMapper和CategoryMapper.xml关联起来了。
7. 这样就拿到了实例化好了的CategoryController,并调用list方法
8. 在list方法中，访问CategoryService,并获取数据，并把数据放在"cs"上，接着服务端跳转到listCategory.jsp去
9. 最后在listCategory.jsp 中显示数据

分页
修改CategoryController
1. 为方法list增加参数Page用于获取浏览器传递过来的分页信息
2. categoryService.list(page); 获取当前页的分类集合
3. 通过categoryService.total(); 获取分类总数
4. 通过page.setTotal(total); 为分页对象设置总数
5. 把分类集合放在"cs"中
6. 把分页对象放在 "page" 中
7. 跳转到listCategory.jsp页面

新增
CategoryController新增add方法
1. add方法映射路径admin_category_add的访问
1.1 参数 Category c接受页面提交的分类名称
1.2 参数 session 用于在后续获取当前应用的路径
1.3 UploadedImageFile 用于接受上传的图片
2. 通过categoryService保存c对象
3. 通过session获取ControllerContext,再通过getRealPath定位存放分类图片的路径。
如果严格按照本教程的做法，使用idea中的tomcat部署的话，那么图片就会存放在:E:\project\tmall_ssm\target\tmall_ssm\img\category 这里
4. 根据分类id创建文件名
5. 如果/img/category目录不存在，则创建该目录，否则后续保存浏览器传过来图片，会提示无法保存
6. 通过UploadedImageFile 把浏览器传递过来的图片保存在上述指定的位置
7. 通过ImageUtil.change2jpg(file); 确保图片格式一定是jpg，而不仅仅是后缀名是jpg.
8. 客户端跳转到admin_category_list

删除
增加删除方法
1. 映射路径admin_category_delete
2. 提供参数接受id注入
3. 提供session参数，用于后续定位文件位置
3. 通过categoryService删除数据
4. 通过session获取ControllerContext然后获取分类图片位置，接着删除分类图片
5. 客户端跳转到 admin_category_list

编辑
增加edit方法
1. 映射admin_category_edit路径的访问
2. 参数id用来接受注入
3. 通过categoryService.get获取Category对象
4. 把对象放在“c"上
5. 返回editCategory.jsp

更新
新增update方法
1. update 方法映射路径admin_category_update的访问
1.1 参数 Category c接受页面提交的分类名称
1.2 参数 session 用于在后续获取当前应用的路径
1.3 UploadedImageFile 用于接受上传的图片
2. 通过categoryService更新c对象
3. 首先判断是否有上传图片，如果有上传，那么通过session获取ControllerContext,再通过getRealPath定位存放分类图片的路径。
如果严格按照本教程的做法，使用idea中的tomcat部署的话，那么图片就会存放在:E:\project\tmall_ssm\target\tmall_ssm\img\category 这里
4. 根据分类id创建文件名
5. 通过UploadedImageFile 把浏览器传递过来的图片保存在上述指定的位置
6. 通过ImageUtil.change2jpg(file); 确保图片格式一定是jpg，而不仅仅是后缀名是jpg.