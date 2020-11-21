package no.java.moresleep.talk

import no.java.moresleep.BadRequest
import no.java.moresleep.Command
import no.java.moresleep.ServiceResult
import no.java.moresleep.UserType

class ReadOneTalk : Command {
    override fun execute(userType: UserType, parameters: Map<String, String>): TalkDetail {
        val talkid = parameters["id"]
        val talkInDb:TalkInDb = talkid?.let { TalkRepo.aTalk(it) }?:throw BadRequest("Unknown talkid $talkid")

        val talkDetail = TalkDetail(talkInDb)
        return talkDetail

    }

}