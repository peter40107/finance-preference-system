<script setup>
import { ref, onMounted, computed } from 'vue'

// 放查詢到的商品資料
const products = ref([])

// 放查詢到的喜好商品資料
const likes = ref([])

// 喜好清單查詢的關鍵字
const searchText = ref('')

// 依照商品代碼或商品名稱來篩選喜好清單
const filteredLikes = computed(() => {

  if (!searchText.value) {
    return likes.value
  }

  return likes.value.filter(item =>
      item.productCode.includes(searchText.value) ||
      item.productName.includes(searchText.value)
  )
})

// 記錄目前修改中商品的流水號
const editingSn = ref(null)

// 加入喜好清單時，放使用者輸入的資料
const form = ref({

  // 使用者 ID
  userId: '',

  // 商品流水號
  productNo: null,

  // 扣款帳號
  account: '',

  // 購買數量
  purchaseQuantity: 1,

  // 備註
  remark: ''
})

// 呼叫後端 API 查詢商品清單
async function loadProducts() {

  const response =
      await fetch('http://localhost:8080/api/products')

  // 將查詢結果轉成 JSON 後存入 products
  products.value =
      await response.json()
}

// 呼叫後端 API 查詢喜好商品資料
async function loadLikes() {

  const response =
      await fetch('http://localhost:8080/api/likes')

  // 將查詢結果轉成 JSON 後存入 likes
  likes.value =
      await response.json()
}

// 將商品加入喜好清單
async function addLike(productNo) {
  if (!form.value.userId) {

    alert('請輸入使用者ID')

    return
  }

  if (!form.value.account) {

    alert('請輸入扣款帳號')

    return
  }

  const response = await fetch(
      'http://localhost:8080/api/likes',
      {
        method: 'POST',

        headers: {
          'Content-Type': 'application/json'
        },

        // 將使用者輸入資料與商品流水號送到後端
        body: JSON.stringify({
          userId: form.value.userId,
          productNo: productNo,
          account: form.value.account,
          purchaseQuantity: form.value.purchaseQuantity,
          remark: form.value.remark
        })
      }
  )
  if (!response.ok) {

    alert('新增失敗，請檢查輸入資料')

    return
  }

  // 新增完成後重新查詢喜好清單
  await loadLikes()

  // 清空輸入欄位
  form.value.userId = ''
  form.value.account = ''
  form.value.purchaseQuantity = 1
  form.value.remark = ''

  alert('加入喜好成功')
}

// 將要修改的資料帶回輸入欄位
function editLike(item) {

  editingSn.value = item.sn

  form.value.userId = item.userId
  form.value.productNo = item.productNo
  form.value.account = item.account
  form.value.purchaseQuantity = item.purchaseQuantity
  form.value.remark = item.remark
}

// 更新喜好商品資料
async function updateLike() {

  if (!editingSn.value) {

    alert('請先選擇要修改的資料')

    return
  }

  const response = await fetch(
      'http://localhost:8080/api/likes/' + editingSn.value,
      {
        method: 'PUT',

        headers: {
          'Content-Type': 'application/json'
        },

        // 將修改後的資料送到後端
        body: JSON.stringify({
          userId: form.value.userId,
          productNo: form.value.productNo,
          account: form.value.account,
          purchaseQuantity: form.value.purchaseQuantity,
          remark: form.value.remark
        })
      }
  )

  if (!response.ok) {

    alert('修改失敗，請檢查輸入資料')

    return
  }

  // 修改完成後重新查詢喜好清單
  await loadLikes()

  editingSn.value = null

  alert('修改成功')
}

// 刪除喜好商品資料
async function deleteLike(sn) {

  const check =
      confirm('確定要刪除這筆喜好商品嗎？')

  if (!check) {
    return
  }

  await fetch(
      'http://localhost:8080/api/likes/' + sn,
      {
        method: 'DELETE'
      }
  )

  // 刪除完成後重新查詢資料
  await loadLikes()

  alert('刪除成功')
}

// 畫面載入完成後自動查詢商品與喜好清單
onMounted(() => {
  loadProducts()
  loadLikes()
})

</script>

<template>
  <div>

    <h1>玉山喜好商品系統</h1>

    <!-- 加入喜好清單需要的資料 -->
    <h3>加入喜好設定</h3>

    <input
        v-model="form.userId"
        placeholder="使用者ID"
    >

    <input
        v-model="form.account"
        placeholder="扣款帳號"
    >

    <input
        v-model="form.purchaseQuantity"
        placeholder="購買數量"
    >

    <input
        v-model="form.remark"
        placeholder="備註"
    >

    <!-- 更新按鈕 -->
    <button @click="updateLike">
      更新
    </button>

    <!-- 商品清單 -->
    <h3>金融商品清單</h3>

    <table border="1">

      <thead>
      <tr>
        <th>商品流水號</th>
        <th>商品類型</th>
        <th>商品代碼</th>
        <th>商品名稱</th>
        <th>商品價格</th>
        <th>手續費率</th>
        <th>操作</th>
      </tr>
      </thead>

      <tbody>

      <!-- 將商品資料逐條顯示 -->
      <tr v-for="product in products" :key="product.no">

        <td>{{ product.no }}</td>
        <td>{{ product.productType }}</td>
        <td>{{ product.productCode }}</td>
        <td>{{ product.productName }}</td>
        <td>{{ product.price }}</td>
        <td>{{ product.feeRate }}</td>

        <td>
          <button @click="addLike(product.no)">
            加入喜好
          </button>
        </td>

      </tr>

      </tbody>

    </table>

    <!-- 喜好商品清單 -->
    <h3>我的喜好商品清單</h3>

    <input
        v-model="searchText"
        placeholder="輸入商品代碼或商品名稱進行查詢"
    >

    <table border="1">

      <thead>
      <tr>
        <th>流水號</th>
        <th>商品代碼</th>
        <th>商品名稱</th>
        <th>電子信箱</th>
        <th>扣款帳號</th>
        <th>數量</th>
        <th>總手續費</th>
        <th>總金額</th>
        <th>備註</th>
        <th>操作</th>
      </tr>
      </thead>

      <tbody>

      <!-- 將喜好清單資料逐條顯示 -->
      <tr v-for="item in filteredLikes" :key="item.sn">

        <td>{{ item.sn }}</td>
        <td>{{ item.productCode }}</td>
        <td>{{ item.productName }}</td>
        <td>{{ item.email }}</td>
        <td>{{ item.account }}</td>
        <td>{{ item.purchaseQuantity }}</td>
        <td>{{ item.totalFee }}</td>
        <td>{{ item.totalAmount }}</td>
        <td>{{ item.remark }}</td>

        <td>
          <button @click="editLike(item)">
            修改
          </button>

          <button @click="deleteLike(item.sn)">
            刪除
          </button>
        </td>

      </tr>

      </tbody>

    </table>

  </div>
</template>

<style>
body {
  font-family: Arial, sans-serif;
}
</style>