<template>
  <div class="page" style="padding-left: 8px; padding-top: 8px">
  </div>
</template>

<script setup>
const emit = defineEmits();
const props = defineProps(['showBtn', 'period', 'active']);
const data = reactive({
  timeType: 'DAY'
});

function getListEnergyConsumptionSummation() {
  loading02.value = true;
  list.value = [];

}

</script>

<style scoped lang="scss">
  .themeDark {
    .page {
      padding: 20px 8px;
      background: #120f2e;

    }
  }
</style>
