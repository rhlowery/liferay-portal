/**
 * Copyright (c) 2000-2009 Liferay, Inc. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.liferay.portal.model;


/**
 * <a href="ListTypeSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a wrapper for {@link ListType}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       ListType
 * @generated
 */
public class ListTypeWrapper implements ListType {
	public ListTypeWrapper(ListType listType) {
		_listType = listType;
	}

	public int getPrimaryKey() {
		return _listType.getPrimaryKey();
	}

	public void setPrimaryKey(int pk) {
		_listType.setPrimaryKey(pk);
	}

	public int getListTypeId() {
		return _listType.getListTypeId();
	}

	public void setListTypeId(int listTypeId) {
		_listType.setListTypeId(listTypeId);
	}

	public java.lang.String getName() {
		return _listType.getName();
	}

	public void setName(java.lang.String name) {
		_listType.setName(name);
	}

	public java.lang.String getType() {
		return _listType.getType();
	}

	public void setType(java.lang.String type) {
		_listType.setType(type);
	}

	public com.liferay.portal.model.ListType toEscapedModel() {
		return _listType.toEscapedModel();
	}

	public boolean isNew() {
		return _listType.isNew();
	}

	public boolean setNew(boolean n) {
		return _listType.setNew(n);
	}

	public boolean isCachedModel() {
		return _listType.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_listType.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _listType.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_listType.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _listType.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _listType.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_listType.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return _listType.clone();
	}

	public int compareTo(com.liferay.portal.model.ListType listType) {
		return _listType.compareTo(listType);
	}

	public int hashCode() {
		return _listType.hashCode();
	}

	public java.lang.String toString() {
		return _listType.toString();
	}

	public java.lang.String toXmlString() {
		return _listType.toXmlString();
	}

	private ListType _listType;
}