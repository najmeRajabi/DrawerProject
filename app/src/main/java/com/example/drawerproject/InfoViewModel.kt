package com.example.drawerproject

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class InfoViewModel:ViewModel() {


    private val _dataList = MutableLiveData<ArrayList<Data>>()
    val dataList: LiveData<ArrayList<Data>> = _dataList

    private val dataArray= arrayListOf(
        Data("مسجد نصیرالملک","مسجد نصیرالملک، شیراز این جعبه جواهر، مسجدی است که هر صبح بازی نور و رنگ را به نمایش می گذارد. قدمت این شاهکاری معماری به قرن نوزدهم بازمی گردد و علاوه بر شیشه های رنگی با کاشیکاری خیره کننده خود مشهور است. درواقع به دلیل کاشی های رنگ رز که در فضای داخلی مسجد به چشم می خورند، به آن لقب مسجد صورتی نیز داده اند","https://persianv.com/gardeshgari/wp-content/uploads/sites/31/2017/04/%D8%A8%D8%B1%D8%AA%D8%B1%DB%8C%D9%86-%D8%A8%D9%86%D8%A7%D9%87%D8%A7%DB%8C-%D8%AA%D8%A7%D8%B1%DB%8C%D8%AE%DB%8C-%D8%A7%DB%8C%D8%B1%D8%A7%D9%86-%DA%A9%D9%87-%D8%A8%DB%8C%D8%B4%D8%AA%D8%B1%DB%8C%D9%86-9.jpg"),
        Data("تخت جمشید","این شهر باستانی پایتخت تشریفاتی امپراتوری هخامنشی و نمونه ای از سبک معماری امپراتوری است. بقایای باستان شناسی نشان می دهد قدمت آن به ۵۱۵ سال قبل از میلاد بازمی گردد و بخشی از سایت از کوه های اطراف کنده شده اند. ساختمان عظیم و مجسمه های باقی مانده شاهدی باورنکردنی از معماری ایران باستان هستند","https://persianv.com/gardeshgari/wp-content/uploads/sites/31/2017/04/%D8%A8%D8%B1%D8%AA%D8%B1%DB%8C%D9%86-%D8%A8%D9%86%D8%A7%D9%87%D8%A7%DB%8C-%D8%AA%D8%A7%D8%B1%DB%8C%D8%AE%DB%8C-%D8%A7%DB%8C%D8%B1%D8%A7%D9%86-%DA%A9%D9%87-%D8%A8%DB%8C%D8%B4%D8%AA%D8%B1%DB%8C%D9%86-12.jpg"),
        Data("شاهچراغ","ضای خارجی این زیارتگاه با کاشی های شیشه ای که نور را در همه جهات بازتاب می کنند، پوشیده شده است. قدمت این زیارتگاه ارزشمند به قرن چهاردهم بازمی گردد و پس از زلزله مورد بازسازی های فراوانی قرار گرفته است. اما هیچ یک از مداخلات از تاثیری که این محیط پرزرق و برق هنگام ورود بر فرد می گذارند، نکاسته است.","https://persianv.com/gardeshgari/wp-content/uploads/sites/31/2017/04/%D8%A8%D8%B1%D8%AA%D8%B1%DB%8C%D9%86-%D8%A8%D9%86%D8%A7%D9%87%D8%A7%DB%8C-%D8%AA%D8%A7%D8%B1%DB%8C%D8%AE%DB%8C-%D8%A7%DB%8C%D8%B1%D8%A7%D9%86-%DA%A9%D9%87-%D8%A8%DB%8C%D8%B4%D8%AA%D8%B1%DB%8C%D9%86-14.jpg"),
        Data("مسجد شیخ لطف الله، اصفهان","قدمت این مسجد که شاهکار معماری ایرانی در دوره صفویه به شمار می رود به قرن هفدهم میلادی بازمی گردد و شهرت خود را مدیون کاشیکاری های ظریف و کربل های پیچیده است. کل ساختمان در هارمونی کامل با توجه دقیق به تناسبات برای به حداکثر رساندن الوهیت و احساس آن در داخل بناست","https://persianv.com/gardeshgari/wp-content/uploads/sites/31/2017/04/%D8%A8%D8%B1%D8%AA%D8%B1%DB%8C%D9%86-%D8%A8%D9%86%D8%A7%D9%87%D8%A7%DB%8C-%D8%AA%D8%A7%D8%B1%DB%8C%D8%AE%DB%8C-%D8%A7%DB%8C%D8%B1%D8%A7%D9%86-%DA%A9%D9%87-%D8%A8%DB%8C%D8%B4%D8%AA%D8%B1%DB%8C%D9%86-15.jpg"),
        Data("برج و قلعه بم در کرمان","شهر کویری باستانی بم در جنوب استان کرمان، یکی دیگر از سایت های میراث جهانی یونسکو است. ارگ بم، بزرگترین بنای خشتی جهان است که قدمت آن به ۲۰۰۰ سال پیش، زمان امپراتوری اشکانی بازمی گردد. این شهر تا سال ۱۷۲۲ بعد از حمله افغان ها تا حد زیادی رها شده بود اما به تدریج جمعیت آن افزایش یافت","https://persianv.com/gardeshgari/wp-content/uploads/sites/31/2017/04/%D8%A8%D8%B1%D8%AA%D8%B1%DB%8C%D9%86-%D8%A8%D9%86%D8%A7%D9%87%D8%A7%DB%8C-%D8%AA%D8%A7%D8%B1%DB%8C%D8%AE%DB%8C-%D8%A7%DB%8C%D8%B1%D8%A7%D9%86-%DA%A9%D9%87-%D8%A8%DB%8C%D8%B4%D8%AA%D8%B1%DB%8C%D9%86-10.jpg"),
        Data("بازار یزد","سال ها انطباق با محیط بیابانی، معماری ایرانی منحصربفردی را در شهر یزد پدید آورد. مرکز تاریخی شهر که بازار را هم دربرمی گیرد، شامل سیستم منحصربفردی از بادگیرها برای تهویه می شود","https://persianv.com/gardeshgari/wp-content/uploads/sites/31/2017/04/%D8%A8%D8%B1%D8%AA%D8%B1%DB%8C%D9%86-%D8%A8%D9%86%D8%A7%D9%87%D8%A7%DB%8C-%D8%AA%D8%A7%D8%B1%DB%8C%D8%AE%DB%8C-%D8%A7%DB%8C%D8%B1%D8%A7%D9%86-%DA%A9%D9%87-%D8%A8%DB%8C%D8%B4%D8%AA%D8%B1%DB%8C%D9%86-11.jpg")
    )
    private fun setData(){
        _dataList.value = dataArray
    }
    fun getDataList(): ArrayList<Data>? {
        setData()
        return _dataList.value
    }
    fun getName(index: Int): String? {
        setData()
        return _dataList.value?.get(index)?.name
    }
    fun getExplain(index: Int): String? {
        setData()
        return _dataList.value?.get(index)?.explain
    }
    fun getImageUrl(index: Int): String? {
        setData()
        return _dataList.value?.get(index)?.image
    }
}