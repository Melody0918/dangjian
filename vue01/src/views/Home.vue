<template xmlns="http://www.w3.org/1999/html">
  <div class="bg" :style="bg" style="height: 371px">
    <el-menu
        :default-active="activeIndex2"
        class="el-menu-demo"
        mode="horizontal"
        @select="handleSelect"
        background-color="#F5F5F5"
        text-color="#D91517"
        active-text-color="#D91517"
        style="width: 70%;margin-left: 210px">
      <el-menu-item index="1" style="width: 187px;text-align: center">党建新闻动态</el-menu-item>
      <el-menu-item index="2" style="width: 187px;text-align: center">
        <router-link to="/article">党务公开</router-link>
      </el-menu-item>
      <el-menu-item index="3" style="width: 187px;text-align: center">
        <router-link to="/activities">专题活动</router-link>
      </el-menu-item>
      <el-menu-item index="4" style="width: 187px;text-align: center">
        <a href="http://dangshi.people.com.cn/GB/index.html#baike" target="_blank">党史学习</a>
      </el-menu-item>
      <el-menu-item index="5" style="width: 160.5px;text-align: center">
        <router-link to="/advertise">文章管理</router-link>
      </el-menu-item>
    </el-menu>
  <el-carousel indicator-position="outside" arrow="always" style="width: 70%;height:338.8px;margin-left: 210px" :interval="5000">
    <el-carousel-item v-for="item in imgArray" :key="item" style="height: 310px">
      <img :src="item" class="rightImg">
    </el-carousel-item>
  </el-carousel>
    <el-divider content-position="center"><span style="color: #D91517">新闻动态</span></el-divider>
    <div class="all">
    <div id="template_content_left" style="width: 22%;margin-left: 20px;margin-right:2%;float: left">
    <div class="content_title">
      党建工作
    </div>
      <ul class="tmo_list">
        <li>
          <a href=""><router-link to="/papers?textContent=以我逆路前行 许你一道彩虹">> {{textContent1}}</router-link></a>
        </li>
        <li>
          <a href=""><router-link to="/papers?textContent=世界读书日|向您推荐一份“党建书单">> 世界读书日|向您推荐一份“党建书单”</router-link></a>
        </li>
        <li>
          <a href=""><router-link to="/papers?textContent=阻击疫情|高举旗帜跟党走，神圣使命肩上扛">> 阻击疫情|高举旗帜跟党走，神圣使命肩上扛</router-link></a>
        </li>
        <li>
          <a href=""><router-link to="/papers?textContent=“守初心、担使命”党性教育大家谈感受">> “守初心、担使命”党性教育大家谈感受</router-link></a>
        </li>
        <li>
          <a href=""><router-link to="/papers?textContent=数读十九大报告 决胜全面建成小康社会 夺取新时代中国特色社会主义伟大胜利!">> 数读十九大报告 决胜全面建成小康社会 夺取新时代中国特色社会主义伟大胜利!</router-link></a>
        </li>
      </ul>
    </div>
      <div id="template_content_l" style="width: 22%;margin-left: 8px;margin-right:2%;float: left">
        <div class="content_title">
          纪检监察
        </div>
        <ul class="tmo_list">
          <li>
            <a href=""><router-link to="/papers?textContent=纪委组织召开拒腐防变警示教育专题讲座">> 纪委组织召开拒腐防变警示教育专题讲座</router-link></a>
          </li>
          <li>
            <a href=""><router-link to="/papers?textContent=“不忘初心 警钟长鸣”——我院赴湖北省警示教育基地参观学习">> “不忘初心 警钟长鸣”——我院赴湖北省警示教育基地参观学习</router-link></a>
          </li>
          <li>
            <a href=""><router-link to="/papers?textContent=我院纪委组织召开2022年度第一次纪委（扩大）会议">> 我院纪委组织召开2022年度第一次纪委（扩大）会议</router-link></a>
          </li>
          <li>
            <a href=""><router-link to="/papers?textContent=我院纪委、纪检监察室组织召开2022年供应商廉洁诚信教育大会">> 我院纪委、纪检监察室组织召开2022年供应商廉洁诚信教育大会</router-link></a>
          </li>
          <li>
            <a href=""><router-link to="/papers?textContent=中共湖北省武汉市武昌区委员会纠正“四风”和作风纪律专项整治推进方案">> 中共湖北省武汉市武昌区委员会纠正“四风”和作风纪律专项整治推进方案</router-link></a>
          </li>
        </ul>
      </div>
      <div id="template_content_r" style="width: 22%;margin-left: 8px;margin-right:2%;float: left">
        <div class="content_title">
          团委工作
        </div>
        <ul class="tmo_list">
          <li>
            <a href=""><router-link to="/papers?textContent=我院召开2022年度五四表彰暨党史学习教育宣讲会">> 我院召开2022年度五四表彰暨党史学习教育宣讲会</router-link></a>
          </li>
          <li>
            <a href=""><router-link to="/papers?textContent=【五四专题MV】奋斗的你，为战疫而歌，致敬我院青年志愿者，青春《逆行》">> 【五四专题MV】奋斗的你，为战疫而歌，致敬我院青年志愿者，青春《逆行》</router-link></a>
          </li>
          <li>
            <a href=""><router-link to="/papers?textContent=学习雷锋精神，为疫情防控贡献力量！">> 学习雷锋精神，为疫情防控贡献力量！</router-link></a>
          </li>
          <li>
            <a href=""><router-link to="/papers?textContent=团心勇抗疫|青春在奉献中闪耀">> 团心勇抗疫|青春在奉献中闪耀</router-link></a>
          </li>
          <li>
            <a href=""><router-link to="/papers?textContent=我院举办表彰大会暨学习党的十九大精神“新时代青年的历史使命与担当”专题讲座">> 我院举办表彰大会暨学习党的十九大精神“新时代青年的历史使命与担当”专题讲座</router-link></a>
          </li>
        </ul>
      </div>
      <div id="template_content_right" style="width: 22%;margin-left: 8px;float: left">
        <div class="content_title">
          党员风采
        </div>
        <ul class="tmo_list">
          <li>
            <a href=""><router-link to="/papers?textContent=共产党员在一线|赵彬彬：穿防护服的你最美">> 共产党员在一线|赵彬彬：穿防护服的你最美</router-link></a>
          </li>
          <li>
            <a href=""><router-link to="/papers?textContent=七一礼赞|我院老党员退休职工陈亦可：心中有爱 肩上扛责 续写爱院情">> 七一礼赞|我院老党员退休职工陈亦可：心中有爱 肩上扛责 续写爱院情</router-link></a>
          </li>
          <li>
            <a href=""><router-link to="/papers?textContent=共产党员在一线|90后白衣战士：在战“疫”中逆风成长">> 共产党员在一线|90后白衣战士：在战“疫”中逆风成长</router-link></a>
          </li>
          <li>
            <a href=""><router-link to="/papers?textContent=共产党员在一线|“尽我的能力，能帮一个患者算一个”">> 共产党员在一线|“尽我的能力，能帮一个患者算一个”</router-link></a>
          </li>
          <li>
            <a href=""><router-link to="/papers?textContent=共产党员在一线|王杰：隔离不隔爱，留观也留情">> 共产党员在一线|王杰：隔离不隔爱，留观也留情</router-link></a>
          </li>
        </ul>
      </div>
  </div>
    <div class="all" style="margin-top: 20px;margin-bottom: 20px">
      <el-divider content-position="center"><span style="color: #D91517">精彩专题</span></el-divider>
      <div style="float: left;margin-left: 10px;margin-right: 10px">
        <a href="http://dangshi.people.com.cn/GB/index.html#baike" target="_blank" style="display: block;margin: 15px 15px 0px 15px">
          <img src="../assets/zhuanti1.png" alt="image1">
        </a>
      </div>
      <div style="float: left;margin-left: 10px;margin-right: 10px">
        <a href="https://www.12371.cn/cxsm/" target="_blank" style="display: block;margin: 15px 15px 0px 15px">
          <img src="../assets/zhuanti2.png" alt="image2">
        </a>
      </div>
      <div style="float: left;margin-left: 10px;margin-right: 10px">
        <a href="http://cpc.people.com.cn/GB/67481/415067/index.html" target="_blank" style="display: block;margin: 15px 15px 0px 15px">
          <img src="../assets/zhuanti3.png" alt="image3">
        </a>
      </div>
      <div style="float: left;margin-left: 10px">
        <a href="https://www.12371.cn/lxyz/" target="_blank" style="display: block;margin: 15px 0px 0px 15px">
          <img src="../assets/zhuanti4.png" alt="image4">
        </a>
      </div>
    </div>
 </div>
</template>
<script>
export default {
  name: "Home",
  data() {
    return {
      textContent1:'以我逆路前行 许你一道彩虹',
      activeIndex: '1',
      activeIndex2: '1',
      imgArray: [
        require('../assets/p1.png'),
        require('../assets/p2.png'),
        require('../assets/p3.png'),
      ],
      bg: {
        backgroundImage: "url(" + require("../assets/background.png") + ")",
        backgroundRepeat: "no-repeat",
        backgroundSize: "100% 100%",
      }
    }
  },
  methods: {
    handleSelect(key, keyPath) {
      console.log(key, keyPath);
    }
  }
}
</script>
<style>
a{
  text-decoration: none;
}
.all {
  float: left;
  width: 100%;
}
div {
  display: block;
}
.content_title {
  display: block;
  height: 28px;
  line-height: 28px;
  background-color:#DCDCDC;
  font-size: 13px;
  text-align: center;
  color: #FD0000;
  border-radius: 40%;
  margin:0px 100px 10px 80px;
}

.tmo_list li {
  color: #7e7d7d;
  margin-bottom: 0px;
  font-size: 14px;
  line-height: 42px;
  height: 42px;
  border-bottom-width: 1px;
  border-bottom-style: dotted;
  border-bottom-color: #CCC;
  margin-top: 0px;
}

li {
  display: list-item;
  text-align: -webkit-match-parent;
  white-space: nowrap;
  text-overflow: ellipsis;
  overflow: hidden;
}
a:-webkit-any-link {
  cursor: pointer;
}

.tmo_list li a {
  color: #7e7d7d;
  font-weight: normal;
  padding-left:10px;
  text-decoration: none;

}
.rightImg {
  width: 100%;
  height: 100%;
}
.el-carousel__item h3 {
  color: #475669;
  font-size: 18px;
  opacity: 0.75;
  line-height: 600px;
  margin: 0;
}

.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n+1) {
  background-color: #d3dce6;
}
</style>