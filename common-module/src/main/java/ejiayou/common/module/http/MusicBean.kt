package ejiayou.common.http

import java.io.Serializable

/**
 * @author:
 * @created on: 2022/7/7 17:11
 * @description:
 */
class MusicBean : Serializable {
    private var fid = 0
    private var kid = 0
    private var filename: String? = null
    private var singername: String? = null
    private var headpic: String? = null
    private var album_name: String? = null
    private var hash: String? = null
    private var ownercount: String? = null
    private var url: String? = null
    private var time: Long = 0
    fun getFid(): Int {
        return fid
    }

    fun setFid(fid: Int) {
        this.fid = fid
    }

    fun getKid(): Int {
        return kid
    }

    fun setKid(kid: Int) {
        this.kid = kid
    }

    fun getFilename(): String? {
        return filename
    }

    fun setFilename(filename: String?) {
        this.filename = filename
    }

    fun getSingername(): String? {
        return singername
    }

    fun setSingername(singername: String?) {
        this.singername = singername
    }

    fun getHeadpic(): String? {
        return headpic
    }

    fun setHeadpic(headpic: String?) {
        this.headpic = headpic
    }

    fun getAlbum_name(): String? {
        return album_name
    }

    fun setAlbum_name(album_name: String?) {
        this.album_name = album_name
    }

    fun getHash(): String? {
        return hash
    }

    fun setHash(hash: String?) {
        this.hash = hash
    }

    fun getOwnercount(): String? {
        return ownercount
    }

    fun setOwnercount(ownercount: String?) {
        this.ownercount = ownercount
    }

    fun getUrl(): String? {
        return url
    }

    fun setUrl(url: String?) {
        this.url = url
    }

    fun getTime(): Long {
        return time
    }

    fun setTime(time: Long) {
        this.time = time
    }
}
