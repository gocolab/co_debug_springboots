<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous" />
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

			<div class="container mt-1">
				<!-- Form list -->
				<div class="row">
					<c:set var="_pagination" value="${resultMap.paginations}" />
					<div class="col row">
						<div class="col">
							<form action="/commonCode/formMulti" method="get">
								<button class="btn btn-info">Form with File</button>
							</form>
						</div>
					</div>
					<div class="col-12">
						<table class="table table-striped table-hover table-bordered">
							<thead>
								<tr class="text-center">
									<th>코드 ID with Files</th>
									<th>코드명</th>
									<th>부모 코드 ID</th>
									<th>Delete</th>
								</tr>
							</thead>
							<tbody>
								<form>
									<c:forEach items='${resultMap.resultList}' var='resultData' varStatus=" loop">
										<tr>
											<td>
												<button class="btn btn-link viewPopup"
													formaction="/commonCode/editMulti/${resultData.COMMON_CODE_ID}">${resultData.COMMON_CODE_ID}</button>
											</td>
											<td>${resultData.NAME}</td>
											<td class="text-center">
												<c:if test="${!empty resultData.PARENT_COMMON_CODE_ID}">
													<div class="form-group">
														${resultData.PARENT_COMMON_CODE_ID}
													</div>
												</c:if>
											</td>
											<td>
												<button class="btn btn-outline-info"
													formaction="/commonCode/delete/${resultData.COMMON_CODE_ID}"
													formmethod="post">Delete</button>
											</td>
										</tr>
									</c:forEach>
									<input type="hidden" name="currentPage" value="${_pagination.currentPage}" />
								</form>
							</tbody>
						</table>
					</div>
					<div class="col">
						총 갯수 : ${_pagination.totalCount}
					</div>
					<div class="col">
						<!-- pagination -->
						<nav aria-label="Page navigation example">
							<ul class="pagination">
								<li class="page-item">
									<a class="page-link" href="#" aria-label="Previous">
										<span class="sr-only">Previous</span>
									</a>
								</li>
								<c:forEach var="i" begin="${_pagination.blockStart}" end="${_pagination.blockEnd}">
									<li class="page-item"><a class="page-link"
											href="/commonCode/listPagination/${i}">${i}</a>
									</li>
								</c:forEach>
								<li class="page-item">
									<a class="page-link" href="#" aria-label="Next">
										<span class="sr-only">Next</span>
									</a>
								</li>
							</ul>
						</nav>
					</div>

				</div>
				<!-- /.table-responsive -->