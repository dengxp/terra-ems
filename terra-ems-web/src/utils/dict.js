import useDictStore from "@/store/modules/dict"
import {getDicts} from "@/api/system/dict/data"

/**
 * 获取字典数据
 */
export function useDict(...args) {
    const res = ref({})
    return (() => {
        args.forEach((dictType, index) => {
            res.value[dictType] = []
            const dictList = useDictStore().getDict(dictType)
            if (dictList) {
                res.value[dictType] = dictList;
            } else {
                getDicts(dictType).then((result) => {
                    res.value[dictType] = result.data.map((p) => ({
                        label: p.dictLabel,
                        value: p.dictValue,
                        elTagType: p.listClass,
                        elTagClass: p.cssClass,
                    }))
                    useDictStore().setDict(dictType, res.value[dictType])
                })
            }
        })
        return toRefs(res.value)
    })()
}

export function useDicNew(...args) {
    const res = ref({});
    return (() => {
        args.forEach(dictType => {
            res.value[dictType] = [];
            const dictList = useDictStore().getDict(dictType);
            if (dictList) {
                res.value[dictType] = dictList;
            } else {

            }
            return toRef(res.value);
        })
    })();
}
