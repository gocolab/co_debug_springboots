<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
</div>
<!-- /.modal -->

<c:set var="_pagination" value="${resultMap.pagination}" />
<c:if test='${_pagination.totalCount > 0}'>

	<div class="row">
		<div class="col">총 갯수 : ${_pagination.totalCount}, ${_pagination.pageBegin}~${_pagination.pageEnd}</div>
		<div class="col">
			<nav aria-label="Page navigation">
				<ul class="pagination justify-content-end">
					<c:if test="${_pagination.currentPage > 1 }">
						<li class="page-item ${_pagination.currentPage > 1 ? 'disabled' : ''}"><button class="page-link"
								formaction="<c:url value='${pageLink}' />" name=currentPage value=1 tabindex="-1">맨 처음</button>
						</li>
					</c:if>
					<li class="page-item ${_pagination.currentBlock > 1 ? 'disabled' : ''}"><button class="page-link"
							formaction="<c:url value='${pageLink}' />" name=currentPage value=${_pagination.previousPage} >&laquo;</button>
					</li>
					<c:forEach var="pageNumber" begin="${_pagination.blockStart}" end="${_pagination.blockEnd}">
						<li class="page-item ${pageNumber==_pagination.currentPage ? 'disabled' : ''}"><button
								class="page-link"
								formaction="<c:url value='${pageLink}' />" name=currentPage value=${pageNumber}>${pageNumber}</button>
						</li>
					</c:forEach>
					<li class="page-item ${_pagination.currentBlock <= _pagination.totalBlock ? 'disabled' : ''}"><button
							class="page-link"
							formaction="<c:url value='${pageLink}' />" name=currentPage value=${_pagination.nextPage}>&raquo;</button>
					</li>
					<c:if test="${_pagination.currentPage < _pagination.totalPage}">
						<li class="page-item ${_pagination.currentPage < _pagination.totalPage ? 'disabled' : ''}"><button
								class="page-link"
								formaction="<c:url value='${pageLink}' />" name=currentPage value=${_pagination.totalPage}>맨
								끝</button></li>
					</c:if>
				</ul>
			</nav>
		</div>
	</div>
</c:if>