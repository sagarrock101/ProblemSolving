package leetcode

class RomanToInteger {

    companion object {
        fun romanToInt(s: String): Int {
            var hashMap: HashMap<Char, Int> = HashMap();

            hashMap['I'] = 1
            hashMap['V'] = 5
            hashMap['X'] = 10
            hashMap['L'] = 50
            hashMap['C'] = 100
            hashMap['D'] = 500
            hashMap['M'] = 1000
            var myNum = 0
            var shouldAddExtra = false

            if(s.length == 1)
                return hashMap[s[0]]!!

//
            //MDCXCV
            //012345
            //myNum = 1000
            //1900
            //
            var i = 0
            while (i <= s.length - 2) {
                if (hashMap[s[i]]!! >= hashMap[s[i + 1]]!!) {
                    myNum += hashMap[s[i]]!!
                    hashMap[s[i]]!!
                    if (i <= s.length - 2)
                        i++
                    shouldAddExtra = true
                } else {
                    shouldAddExtra = false
                    myNum += (hashMap[s[i + 1]]!! - hashMap[s[i]]!!)
                    if (i <= s.length - 2)
                        i += 2
                    if(i == s.length - 1) {
                        myNum += hashMap[s[i]]!!
                        break
                    }
                }
            }
            if (shouldAddExtra)
                myNum += hashMap[s[s.length - 1]]!!

            return myNum
        }

    }

}