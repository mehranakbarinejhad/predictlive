package com.liyanamarket.predictlive.dataclass

data class Match(
     var matchid:Int,
     var matchdate:String,
     var matchhour:String,
     var hometeam:List<teamnamelogo>,
     var homegols:Int,
     var guestteam:List<teamnamelogo>,
     var teamguestgols:Int,
     var status:String



)

data class teamnamelogo(
     var id:Int,
     var name:String,
     var logo:String
)
