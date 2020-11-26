package kr.hs.emirim.cho.pj_student

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDBHelper(var context: Context) : SQLiteOpenHelper(context, "studentDB", null, 1){
    override fun onCreate(db: SQLiteDatabase?) {
        var tableCreSql="create table studentTBL ( hb char(4), name varchar(20), dept varchar(20), sajin varchar(10), "+
                "hdong1 varchar(200), hdong2 varchar(600) );"

        db!!.execSQL(tableCreSql)

        db!!.execSQL("insert into studentTBL values('1910', '성덕선', '항공비지니스과', 's1', '별명 특공대(특별히 공부 못하는 대가리의 줄임말)\n, 동일과 일화의 차녀이며, 언니 보라에게 눌리고 동생 노을에게 치이는 설움 많은 동일이네 둘째 딸이다', '택이와 사귀게 된다.')")
        db!!.execSQL("insert into studentTBL values('1900', '류정환', '군인과', 's2', '세상만사에 불만 많고 까칠한, 성균네 둘째 아들.\n 매사에 불만 많고 투덜대느라 한 번에 YES 하는 법이 없다.', '덕선이를 좋아하지만 타이밍. 타이밍 때문에 덕선이를 놓친다.')")
        db!!.execSQL("insert into studentTBL values('1901', '성선우', '흉부외과', 's3', '일명 쌍문동 참인간. 쌍문고등학교 전교 회장이자 학급 반장이며, 공부도 전교 1등에, 운동이든 춤이든 다 잘한다.쌍문동 골목 모든 엄마들의 워너비 아들이며, 친구들이나 선생님들에게도 모두 인기 많은 젠틀맨이다. 또한 또래 남자 아이들에게서는 찾아볼 수 없는 다정하고 살가운 성격의 소유자다. \n', '덕선이의 언니 보라와 결혼하게 된다.')")
        db!!.execSQL("insert into studentTBL values('xxxx', '최택', '바둑기사과', 's4', '프로 六단(1988년 당시). 바둑계의 돌부처로 불리는, 대한민국 국보급 바둑기사다. 덕선이나 친구들이 부르는 별명은 희동이나 천연기념물. 어른들 사이에선 일명 최 사범이라고 불린다. \n 11살에 프로에 입단, 13살에 최연소 타이틀 획득 이후, 1988년 현재까지 바둑 랭킹 1위', '덕선이와 사귀게 된다.')")
        db!!.execSQL("insert into studentTBL values('1903', '류동룡', '실용음악과', 's5', '춤으로 학교를 평정한 쌍문동 박남정. 소방차와 박남정의 댄스부터 바비 브라운의 토끼춤까지 못 추는 춤이 없다. 영어 단어 하나 제대로 못 외우지만, 한 번 본 춤은 그대로 따라 추는 타고난 춤꾼! ', '덕선이와 같은 특공대이다')")
        db!!.execSQL("insert into studentTBL values('1810', '성보라', '판사과', 's6', '응답하라 1988 서브 여주인공이자, 성씨 일가의 장녀. 그리고 쌍문동의 미친년. 서울대학교 수학교육과 2학년 재학 중이며, 집안의 자랑이자 보물같은 존재다. \n하고 싶은 것은 반드시 해야만 직성이 풀리는 사람으로, 화가 나면 물불 가리지 않는 다혈질같은 성격이다.', '선우와 사귀게 된다.')")
        db!!.execSQL("insert into studentTBL values('1700', '류정봉', '불교과', 's7', '성균 & 미란의 첫째 아들이다. 6수생이자 집안의 유일한 걱정거리. 공부 외에 모든 것에 관심이 있는 원조 오덕후. \n 3년 전인 1985년, 동네에서 가장 가난하게 살고 있던 집안을 그의 취미로 일으킨 전적이 있어 가족 누구도 정봉을 함부로 대하지 못한다.', '덕선이 친구 미옥이와 사귀게된다.')")
        db!!.execSQL("insert into studentTBL values('1911', '장미옥', '외교과', 's8', '왕자현과 함께 성덕선의 절친이며, 절친들 사이에선 장만옥으로 불린다. 몇 개의 상점을 소유하고 있는 원단 도매상 집안의 딸로, 매우 부유한 집에서 산다. 또한 운명을 믿지 않았지만 우연히 우산 안으로 뛰어든 김정봉과의 만남으로 운명을 믿게 되고, 그와 연애를 하지만 아버지에 의해서 강제로 이별하게 된다. 그 후 오랜 헤어짐 끝에 운명처럼 다시 만나 결혼까지 한다.', '덕선이와 절친이다.')")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("drop table if exists studentTBL ")
        onCreate(db)
    }


}