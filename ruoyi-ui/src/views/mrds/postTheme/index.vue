<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="主题名称" prop="title">
        <el-input
          v-model="queryParams.title"
          placeholder="请输入主题名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="性别" prop="sex">
        <el-input
          v-model="queryParams.sex"
          placeholder="请输入性别"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <!-- <el-form-item label="封面图片" prop="coverUrl">
        <el-input
          v-model="queryParams.coverUrl"
          placeholder="请输入封面图片"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item> -->
      <!-- <el-form-item label="描述" prop="description">
        <el-input
          v-model="queryParams.description"
          placeholder="请输入描述"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item> -->
      <el-form-item label="开始时间" prop="startAt">
        <el-input
          v-model="queryParams.startAt"
          placeholder="请输入主题开始时间"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="结束时间" prop="endAt">
        <el-input
          v-model="queryParams.endAt"
          placeholder="请输入主题结束时间"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <!-- <el-form-item label="主题下帖子数量" prop="postsNums">
        <el-input
          v-model="queryParams.postsNums"
          placeholder="请输入主题下帖子数量"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item> -->
      <!-- <el-form-item label="创建时间" prop="createdAt">
        <el-input
          v-model="queryParams.createdAt"
          placeholder="请输入创建时间"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="更新时间" prop="updatedAt">
        <el-input
          v-model="queryParams.updatedAt"
          placeholder="请输入更新时间"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item> -->
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['mrds:postTheme:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['mrds:postTheme:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['mrds:postTheme:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['mrds:postTheme:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="postThemeList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['mrds:postTheme:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['mrds:postTheme:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
      <el-table-column label="id" align="center" prop="id" sortable/>
      <el-table-column label="性别" align="center" prop="sex" #default="scope">
        {{ scope.row.sex == 1 ? '男':'女' }}
      </el-table-column>
      <el-table-column label="主题名称" align="center" prop="title" />
      <el-table-column label="封面图片" align="center" prop="coverUrl" #default="scope">
        <img :src="scope.row.coverUrl" width="50"/>
      </el-table-column>
      <el-table-column label="描述" align="center" prop="description" />
      <el-table-column label="主题开始时间" align="center" prop="startAt" />
      <el-table-column label="主题结束时间" align="center" prop="endAt" />
      <el-table-column label="主题下帖子数量" align="center" prop="postsNums"/>
      <el-table-column label="状态" align="center" prop="status"  #default="scope">
        {{ scope.row.status == 10 ? '正常' : '停用' }}
      </el-table-column>
      <el-table-column label="创建时间" align="center" prop="createdAt" />
      <el-table-column label="更新时间" align="center" prop="updatedAt" />
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改活动管理对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="主题名称" prop="title">
          <el-input v-model="form.title" placeholder="请输入主题名称" />
        </el-form-item>
        <el-form-item label="封面图片" prop="coverUrl">
          <el-input v-model="form.coverUrl" placeholder="请输入封面图片" />
        </el-form-item>
        <el-form-item label="描述" prop="description">
          <el-input v-model="form.description" placeholder="请输入描述" />
        </el-form-item>
        <el-form-item label="主题开始时间" prop="startAt">
          <el-input v-model="form.startAt" placeholder="请输入主题开始时间" />
        </el-form-item>
        <el-form-item label="主题结束时间" prop="endAt">
          <el-input v-model="form.endAt" placeholder="请输入主题结束时间" />
        </el-form-item>
        <el-form-item label="主题下帖子数量" prop="postsNums">
          <el-input v-model="form.postsNums" placeholder="请输入主题下帖子数量" />
        </el-form-item>
        <el-form-item label="创建时间" prop="createdAt">
          <el-input v-model="form.createdAt" placeholder="请输入创建时间" />
        </el-form-item>
        <el-form-item label="更新时间" prop="updatedAt">
          <el-input v-model="form.updatedAt" placeholder="请输入更新时间" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listPostTheme, getPostTheme, delPostTheme, addPostTheme, updatePostTheme } from "@/api/mrds/postTheme";

export default {
  name: "PostTheme",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 活动管理表格数据
      postThemeList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        sex: null,
        title: null,
        coverUrl: null,
        description: null,
        startAt: null,
        endAt: null,
        postsNums: null,
        status: null,
        createdAt: null,
        updatedAt: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        sex: [
          { required: true, message: "性别 1 男；2 女不能为空", trigger: "change" }
        ],
        title: [
          { required: true, message: "主题名称不能为空", trigger: "blur" }
        ],
        coverUrl: [
          { required: true, message: "封面图片不能为空", trigger: "blur" }
        ],
        description: [
          { required: true, message: "描述不能为空", trigger: "blur" }
        ],
        startAt: [
          { required: true, message: "主题开始时间不能为空", trigger: "blur" }
        ],
        endAt: [
          { required: true, message: "主题结束时间不能为空", trigger: "blur" }
        ],
        postsNums: [
          { required: true, message: "主题下帖子数量不能为空", trigger: "blur" }
        ],
        status: [
          { required: true, message: "状态 10 上架中 0 下架不能为空", trigger: "change" }
        ],
        createdAt: [
          { required: true, message: "创建时间不能为空", trigger: "blur" }
        ],
        updatedAt: [
          { required: true, message: "更新时间不能为空", trigger: "blur" }
        ]
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询活动管理列表 */
    getList() {
      this.loading = true;
      listPostTheme(this.queryParams).then(response => {
        this.postThemeList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        sex: null,
        title: null,
        coverUrl: null,
        description: null,
        startAt: null,
        endAt: null,
        postsNums: null,
        status: null,
        createdAt: null,
        updatedAt: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      if(this.queryParams.sex==='男')this.queryParams.sex='1';
      if(this.queryParams.sex==='女')this.queryParams.sex='2';
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加活动管理";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getPostTheme(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改活动管理";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updatePostTheme(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addPostTheme(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除活动管理编号为"' + ids + '"的数据项？').then(function() {
        return delPostTheme(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('mrds/postTheme/export', {
        ...this.queryParams
      }, `postTheme_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
