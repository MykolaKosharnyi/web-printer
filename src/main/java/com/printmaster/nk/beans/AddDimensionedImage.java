package com.printmaster.nk.beans;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
	
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.util.IOUtils;

	/**
39	 * Demonstrates how to add an image to a worksheet and set that images size
40	 * to a specific number of millimetres irrespective of the width of the columns
41	 * or height of the rows. Overridden methods are provided so that the location
42	 * of the image - the cells row and column coordinates that define the top
43	 * left hand corners of the image - can be identified either in the familiar
44	 * Excel manner - A1 for instance - or using POI's methodology of a column and
45	 * row index where 0, 0 would indicate cell A1.
46	 *
47	 * The best way to make use of these techniques is to delay adding the image to
48	 * the sheet until all other work has been completed. That way, the sizes of
49	 * all rows and columns will have been adjusted - assuming that step was
50	 * necessary. Even though the anchors type is set to prevent the image moving
51	 * or re-sizing, this setting does not have any effect until the sheet is being
52	 * viewed using the Excel application.
53	 *
54	 * The key to the process is the ClientAnchor class. It defines methods that allow
55	 * us to define the location of an image by specifying the following;
56	 *
57	 *      * How far - in terms of coordinate positions - the image should be inset
58	 *      from the left hand border of a cell.
59	 *      * How far - in terms of coordinate positions - the image should be inset
60	 *      from the from the top of the cell.
61	 *      * How far - in terms of coordinate positions - the right hand edge of
62	 *      the image should protrude into a cell (measured from the cells left hand
63	 *      edge to the images right hand edge).
64	 *      * How far - in terms of coordinate positions - the bottom edge of the
65	 *      image should protrude into a row (measured from the cells top edge to
66	 *      the images bottom edge).
67	 *      * The index of the column that contains the cell whose top left hand
68	 *      corner should be aligned with the top left hand corner of the image.
69	 *      * The index of the row that contains the cell whose top left hand corner
70	 *      should be aligned with the images top left hand corner.
71	 *      * The index of the column that contains the cell whose top left hand
72	 *      corner should be aligned with the images bottom right hand corner
73	 *      * The index number of the row that contains the cell whose top left
74	 *      hand corner should be aligned with the images bottom right hand corner.
75	 *
76	 * It can be used to add an image into cell A1, for example, in the following
77	 * manner;
78	 *
79	 *      ClientAnchor anchor = sheet.getWorkbook().getCreationHelper().createClientAnchor();
80	 *
81	 *      anchor.setDx1(0);
82	 *      anchor.setDy1(0);
83	 *      anchor.setDx2(0);
84	 *      anchor.setDy2(0);
85	 *      anchor.setCol1(0);
86	 *      anchor.setRow1(0);
87	 *      anchor.setCol2(1);
88	 *      anchor.setRow2(1);
89	 *
90	 * Taken together, the first four methods define the locations of the top left
91	 * and bottom right hand corners of the image if you imagine that the image is
92	 * represented by a simple rectangle. The setDx1() and setDy1() methods locate
93	 * the top left hand corner of the image while setDx2() and and Dy2() locate the
94	 * bottom right hand corner of the image. An individual image can be inserted
95	 * into a single cell or is can lie across many cells and the latter four methods
96	 * are used to define just where the image should be positioned. They do this by
97	 * again by identifying where the top left and bottom right hand corners of the
98	 * image should be located but this time in terms of the indexes of the cells
99	 * in which those corners should be located. The setCol1() and setRow1() methods
100	 * together identify the cell that should contain the top left hand corner of
101	 * the image while setCol2() and setRow2() do the same for the images bottom
102	 * right hand corner. 
103	 *
104	 * Knowing that, it is possible to look again at the example above and to see
105	 * that the top left hand corner of the image will be located in cell A1 (0, 0)
106	 * and it will be aligned with the very top left hand corner of the cell. Likewise,
107	 * the bottom right hand corner of the image will be located in cell B2 (1, 1) and
108	 * it will again be aligned with the top left hand corner of the cell. This has the
109	 * effect of making the image seem to occupy the whole of cell A1. Interestingly, it
110	 * also has an effect on the images resizing behaviour because testing has 
111	 * demonstrated that if the image is wholly contained within one cell and is not
112	 * 'attached' for want of a better word, to a neighbouring cell, then that image
113	 * will not increase in size in response to the user dragging the column wider
114	 * or the cell higher.
115	 *
116	 * The following example demonstrates a slightly different way to insert an
117	 * image into cell A1 and to ensure that it occupies the whole of the cell. This
118	 * is accomplished by specifying the the images bottom right hand corner should be
119	 * aligned with the bottom right hand corner of the cell. It is also a case
120	 * where the image will not increase in size if the user increases the size of
121	 * the enclosing cell - irrespective of the anchors type - but it will reduce in
122	 * size if the cell is made smaller.
123	 *
124	 *      ClientAnchor anchor = sheet.getWorkbook().getCreationHelper().createClientAnchor();
125	 *
126	 *      anchor.setDx1(0);
127	 *      anchor.setDy1(0);
128	 *      anchor.setDx2(1023);
129	 *      anchor.setDy2(255);
130	 *      anchor.setCol1(0);
131	 *      anchor.setRow1(0);
132	 *      anchor.setCol2(0);
133	 *      anchor.setRow2(0);
134	 *
135	 * Note that the final four method calls all pass the same value and seem to
136	 * indicate that the images top left hand corner is aligned with the top left
137	 * hand corner of cell A1 and that it's bottom right hand corner is also
138	 * aligned with the top left hand corner of cell A1. Yet, running this code
139	 * would see the image fully occupying cell A1. That is the result of the
140	 * values passed to parameters three and four; these I have referred to as
141	 * determining the images coordinates within the cell. They indicate that the
142	 * image should occupy - in order - the full width of the column and the full
143	 * height of the row.
144	 *
145	 * The co-ordinate values shown are the maxima; and they are independent of
146	 * row height/column width and of the font used. Passing 255 will always result
147	 * in the image occupying the full height of the row and passing 1023 will
148	 * always result in the image occupying the full width of the column. They help
149	 * in situations where an image is larger than a column/row and must overlap
150	 * into the next column/row. Using them does mean, however, that it is often
151	 * necessary to perform conversions between Excels characters units, points,
152	 * pixels and millimetres in order to establish how many rows/columns an image
153	 * should occupy and just what the various insets ought to be.
154	 *
155	 * Note that the setDx1(int) and setDy1(int) methods of the ClientAchor class
156	 * are not made use of in the code that follows. It would be fairly trivial
157	 * however to extend this example further and provide methods that would centre
158	 * an image within a cell or allow the user to specify that a plain border a
159	 * fixed number of millimetres wide should wrap around the image. Those first
160	 * two parameters would make this sort of functionality perfectly possible.
161	 *
162	 * Owing to the various conversions used, the actual size of the image may vary
163	 * from that required; testing has so far found this to be in the region of
164	 * plus or minus two millimetres. Most likely by modifying the way the
165	 * calculations are performed - possibly using double(s) throughout and
166	 * rounding the values at the correct point - it is likely that these errors
167	 * could be reduced or removed.
168	 *
169	 * A note concerning Excels image resizing behaviour. The ClientAnchor
170	 * class contains a method called setAnchorType(int) which can be used to
171	 * determine how Excel will resize an image in response to the user increasing
172	 * or decreasing the dimensions of the cell containing the image. There are 
173	 * three values that can be passed to this method; 0 = To move and size the 
174	 * image with the cell, 2 = To move but don't size the image with the cell,
175	 * 3 = To prevent the image from moving or being resized along with the cell. If
176	 * an image is inserted using this class and placed into a single cell then if
177	 * the setAnchorType(int) method is called and a value of either 0 or 2 passed
178	 * to it, the resultant resizing behaviour may be a surprise. The image will not
179	 * grow in size of the column is made wider or the row higher but it will shrink
180	 * if the columns width or rows height are reduced.
181	 *
182	 * @author Mark Beardsley [msb at apache.org] and Mark Southern [southern at scripps.edu]
183	 * @version 1.00 5th August 2009.
184	 *          2.00 26th February 2010.
185	 *               Ported to make use of the the SS usermodel classes.
186	 *               Ability to reuse the Drawing Patriarch so that multiple images
187	 *               can be inserted without unintentionally erasing earlier images.
188	 *               Check on image type added; i.e. jpg, jpeg or png.
189	 *               The String used to contain the files name is now converted
190	 *               into a URL.
191	 *          2.10 17th May 2012
192	 *               Corrected gross error that occurred when using the code with
193	 *               XSSF or SXSSF workbooks. In short, the code did not correctly
194	 *               calculate the size of the image(s) owing to the use of EMUs
195	 *               within the OOXML file format. That problem has largely been
196	 *               corrected although it should be mentioned that images are not
197	 *               sized with the same level of accuracy. Discrepancies of up to
198	 *               2mm have been noted in testing. Further investigation will
199	 *               continue to rectify this issue.
200	 */
	public class AddDimensionedImage {
	
	    // Four constants that determine how - and indeed whether - the rows
	    // and columns an image may overlie should be expanded to accomodate that
	    // image.
	    // Passing EXPAND_ROW will result in the height of a row being increased
	    // to accomodate the image if it is not already larger. The image will
	    // be layed across one or more columns.
	    // Passing EXPAND_COLUMN will result in the width of the column being
	    // increased to accomodate the image if it is not already larger. The image
	    // will be layed across one or many rows.
	    // Passing EXPAND_ROW_AND_COLUMN will result in the height of the row
	    // bing increased along with the width of the column to accomdate the
	    // image if either is not already larger.
	    // Passing OVERLAY_ROW_AND_COLUMN will result in the image being layed
	    // over one or more rows and columns. No row or column will be resized,
	    // instead, code will determine how many rows and columns the image should
	    // overlie.
	    public static final int EXPAND_ROW = 1;
	    public static final int EXPAND_COLUMN = 2;
	    public static final int EXPAND_ROW_AND_COLUMN = 3;
	    public static final int OVERLAY_ROW_AND_COLUMN = 7;
	    
	    // Modified to support EMU - English Metric Units - used within the OOXML
	    // workbooks, this multoplier is used to convert between measurements in
	    // millimetres and in EMUs
	    private static final int EMU_PER_MM = 36000;
	    
	    /**
	     * Add an image to a worksheet.
	     *
232	     * @param cellNumber A String that contains the location of the cell whose
233	     *                   top left hand corner should be aligned with the top
234	     *                   left hand corner of the image; for example "A1", "A2"
235	     *                   etc. This is to support the familiar Excel syntax.
236	     *                   Whilst images are are not actually inserted into cells
237	     *                   this provides a convenient method of indicating where
238	     *                   the image should be positioned on the sheet.
239	     * @param sheet A reference to the sheet that contains the cell referenced
240	     *              above.
241	     * @param drawing An instance of the DrawingPatriarch class. This is now
242	     *                passed into the method where it was, previously, recovered
243	     *                from the sheet in order to allow multiple pictures be
244	     *                inserted. If the patriarch was not 'cached in this manner
245	     *                each time it was created any previously positioned images
246	     *                would be simply over-written.
247	     * @param imageFile An instance of the URL class that encapsulates the name
248	     *                  of and path to the image that is to be 'inserted into'
249	     *                  the sheet.
250	     * @param reqImageWidthMM A primitive double that contains the required
251	     *                        width of the image in millimetres.
252	     * @param reqImageHeightMM A primitive double that contains the required
253	     *                         height of the image in millimetres.
254	     * @param resizeBehaviour A primitive int whose value will determine how
255	     *                        the code should react if the image is larger than
256	     *                        the cell referenced by the cellNumber parameter.
257	     *                        Four constants are provided to determine what
258	     *                        should happen;
259	     *                          AddDimensionedImage.EXPAND_ROW
260	     *                          AddDimensionedImage.EXPAND_COLUMN
261	     *                          AddDimensionedImage.EXPAND_ROW_AND_COLUMN
262	     *                          AddDimensionedImage.OVERLAY_ROW_AND_COLUMN
263	     * @throws java.io.FileNotFoundException If the file containing the image
264	     *                                       cannot be located.
265	     * @throws java.io.IOException If a problem occurs whilst reading the file
266	     *                             of image data.
267	     * @throws java.lang.IllegalArgumentException If an invalid value is passed
268	     *                                            to the resizeBehaviour
269	     *                                            parameter.
270	     */
	    public void addImageToSheet(String cellNumber, Sheet sheet, Drawing drawing,
	            URL imageFile, double reqImageWidthMM, double reqImageHeightMM,
	            int resizeBehaviour) throws IOException, IllegalArgumentException {
	        // Convert the String into column and row indices then chain the
	        // call to the overridden addImageToSheet() method.
	        CellReference cellRef = new CellReference(cellNumber);
	        this.addImageToSheet(cellRef.getCol(), cellRef.getRow(), sheet, drawing,
	                imageFile, reqImageWidthMM, reqImageHeightMM,resizeBehaviour);
	    }
	
	    /**
282	     * Add an image to a worksheet.
283	     *
284	     * @param colNumber A primitive int that contains the index number of a
285	     *                  column on the worksheet; POI column indices are zero
286	     *                  based. Together with the rowNumber parameter's value,
287	     *                  this parameter identifies a cell on the worksheet. The
288	     *                  images top left hand corner will be aligned with the
289	     *                  top left hand corner of this cell.
290	     * @param rowNumber A primitive int that contains the index number of a row
291	     *                  on the worksheet; POI row indices are zero based.
292	     *                  Together with the rowNumber parameter's value, this
293	     *                  parameter identifies a cell on the worksheet. The
294	     *                  images top left hand corner will be aligned with the
295	     *                  top left hand corner of this cell.
296	     * @param sheet A reference to the sheet that contains the cell identified
297	     *              by the two parameters above.
298	     * @param drawing An instance of the DrawingPatriarch class. This is now
299	     *                passed into the method where it was, previously, recovered
300	     *                from the sheet in order to allow multiple pictures be
301	     *                inserted. If the patriarch was not 'cached in this manner
302	     *                each time it was created any previously positioned images
303	     *                would be simply over-written.
304	     * @param imageFile An instance of the URL class that encapsulates the name
305	     *                  of and path to the image that is to be 'inserted into'
306	     *                  the sheet.
307	     * @param reqImageWidthMM A primitive double that contains the required
308	     *                        width of the image in millimetres.
309	     * @param reqImageHeightMM A primitive double that contains the required
310	     *                         height of the image in millimetres.
311	     * @param resizeBehaviour A primitive int whose value will determine how
312	     *                        the code should react if the image is larger than
313	     *                        the cell referenced by the colNumber and
314	     *                        rowNumber parameters. Four constants are provided
315	     *                        to determine what should happen;
316	     *                          AddDimensionedImage.EXPAND_ROW
317	     *                          AddDimensionedImage.EXPAND_COLUMN
318	     *                          AddDimensionedImage.EXPAND_ROW_AND_COLUMN
319	     *                          AddDimensionedImage.OVERLAY_ROW_AND_COLUMN
320	     * @throws java.io.FileNotFoundException If the file containing the image
321	     *                                       cannot be located.
322	     * @throws java.io.IOException If a problem occurs whilst reading the file
323	     *                             of image data.
324	     * @throws java.lang.IllegalArgumentException If an invalid value is passed
325	     *                                            to the resizeBehaviour
326	     *                                            parameter or if the extension
327	     *                                            of the image file indicates that
328	     *                                            it is of a type that cannot
329	     *                                            currently be added to the worksheet.
330	     */
	    public void addImageToSheet(int colNumber, int rowNumber, Sheet sheet, Drawing drawing,
	            URL imageFile, double reqImageWidthMM, double reqImageHeightMM,
	            int resizeBehaviour) throws IOException,
	                                                     IllegalArgumentException {
	        ClientAnchor anchor = null;
	        ClientAnchorDetail rowClientAnchorDetail = null;
	        ClientAnchorDetail colClientAnchorDetail = null;
	        int imageType = 0;
	
	        // Validate the resizeBehaviour parameter.
	        if((resizeBehaviour != AddDimensionedImage.EXPAND_COLUMN) &&
	           (resizeBehaviour != AddDimensionedImage.EXPAND_ROW) &&
	           (resizeBehaviour != AddDimensionedImage.EXPAND_ROW_AND_COLUMN) &&
	           (resizeBehaviour != AddDimensionedImage.OVERLAY_ROW_AND_COLUMN)) {
	            throw new IllegalArgumentException("Invalid value passed to the " +
	                    "resizeBehaviour parameter of AddDimensionedImage.addImageToSheet()");
	        }
	
	        // Call methods to calculate how the image and sheet should be
	        // manipulated to accomodate the image; columns and then rows.
	        colClientAnchorDetail = this.fitImageToColumns(sheet, colNumber,
	                reqImageWidthMM, resizeBehaviour);
	        rowClientAnchorDetail = this.fitImageToRows(sheet, rowNumber,
	                reqImageHeightMM, resizeBehaviour);
	
	        // Having determined if and how to resize the rows, columns and/or the
	        // image, create the ClientAnchor object to position the image on
	        // the worksheet. Note how the two ClientAnchorDetail records are
	        // interrogated to recover the row/column co-ordinates and any insets.
	        // The first two parameters are not used currently but could be if the
	        // need arose to extend the functionality of this code by adding the
	        // ability to specify that a clear 'border' be placed around the image.
	        anchor = sheet.getWorkbook().getCreationHelper().createClientAnchor();
	
	        anchor.setDx1(0);
	        anchor.setDy1(0);
	        anchor.setDx2(colClientAnchorDetail.getInset());
	        anchor.setDy2(rowClientAnchorDetail.getInset());
	        anchor.setCol1(colClientAnchorDetail.getFromIndex());
	        anchor.setRow1(rowClientAnchorDetail.getFromIndex());
	        anchor.setCol2(colClientAnchorDetail.getToIndex());
	        anchor.setRow2(rowClientAnchorDetail.getToIndex());
	
	        // For now, set the anchor type to do not move or resize the
	        // image as the size of the row/column is adjusted. This could easilly
	        // become another parameter passed to the method. Please read the note
	        // above regarding the behaviour of image resizing.
	        anchor.setAnchorType(ClientAnchor.AnchorType.MOVE_AND_RESIZE);
	
	        // Now, add the picture to the workbook. Note that unlike the similar
	        // method in the HSSF Examples section, the image type is checked. First,
	        // the image files location is identified by interrogating the URL passed
	        // to the method, the images type is identified before it is added to the
	        // sheet.
	        String sURL = imageFile.toString().toLowerCase();
	        if( sURL.endsWith(".png") ) {
	            imageType = Workbook.PICTURE_TYPE_PNG;
	        }
	        else if( sURL.endsWith("jpg") || sURL.endsWith(".jpeg") ) {
	            imageType = Workbook.PICTURE_TYPE_JPEG;
	        }
	        else  {
	            throw new IllegalArgumentException("Invalid Image file : " +
	                sURL);
	        }
	        int index = sheet.getWorkbook().addPicture(
	            IOUtils.toByteArray(imageFile.openStream()), imageType);
	        drawing.createPicture(anchor, index);
	    }
	
	    /**
402	     * Determines whether the sheets columns should be re-sized to accomodate
403	     * the image, adjusts the columns width if necessary and creates then
404	     * returns a ClientAnchorDetail object that facilitates construction of
405	     * an ClientAnchor that will fix the image on the sheet and establish
406	     * it's size.
407	     *
408	     * @param sheet A reference to the sheet that will 'contain' the image.
409	     * @param colNumber A primtive int that contains the index number of a
410	     *                  column on the sheet.
411	     * @param reqImageWidthMM A primitive double that contains the required
412	     *                        width of the image in millimetres
413	     * @param resizeBehaviour A primitive int whose value will indicate how the
414	     *                        width of the column should be adjusted if the
415	     *                        required width of the image is greater than the
416	     *                        width of the column.
417	     * @return An instance of the ClientAnchorDetail class that will contain
418	     *         the index number of the column containing the cell whose top
419	     *         left hand corner also defines the top left hand corner of the
420	     *         image, the index number column containing the cell whose top
421	     *         left hand corner also defines the bottom right hand corner of
422	     *         the image and an inset that determines how far the right hand
423	     *         edge of the image can protrude into the next column - expressed
424	     *         as a specific number of coordinate positions.
425	     */
	    private ClientAnchorDetail fitImageToColumns(Sheet sheet, int colNumber,
	            double reqImageWidthMM, int resizeBehaviour) {
	
	        double colWidthMM = 0.0D;
	        double colCoordinatesPerMM = 0.0D;
	        int pictureWidthCoordinates = 0;
	        ClientAnchorDetail colClientAnchorDetail = null;
	
	        // Get the colum's width in millimetres
	        colWidthMM = ConvertImageUnits.widthUnits2Millimetres(
	                (short)sheet.getColumnWidth(colNumber));
	
	        // Check that the column's width will accomodate the image at the
	        // required dimension. If the width of the column is LESS than the
	        // required width of the image, decide how the application should
	        // respond - resize the column or overlay the image across one or more
	        // columns.
	        if(colWidthMM < reqImageWidthMM) {
	
	            // Should the column's width simply be expanded?
	            if((resizeBehaviour == AddDimensionedImage.EXPAND_COLUMN) ||
	               (resizeBehaviour == AddDimensionedImage.EXPAND_ROW_AND_COLUMN)) {
	                // Set the width of the column by converting the required image
	                // width from millimetres into Excel's column width units.
	                sheet.setColumnWidth(colNumber,
	                        ConvertImageUnits.millimetres2WidthUnits(reqImageWidthMM));
	                // To make the image occupy the full width of the column, convert
	                // the required width of the image into co-ordinates. This value
	                // will become the inset for the ClientAnchorDetail class that
	                // is then instantiated.
	                if(sheet instanceof HSSFSheet) {
	                    colWidthMM = reqImageWidthMM;
	                    colCoordinatesPerMM = ConvertImageUnits.TOTAL_COLUMN_COORDINATE_POSITIONS /
	                        colWidthMM;
	                    pictureWidthCoordinates = (int)(reqImageWidthMM * colCoordinatesPerMM);
	
	                }
	                else {
	                    pictureWidthCoordinates = (int)reqImageWidthMM * AddDimensionedImage.EMU_PER_MM;
	                }
	                colClientAnchorDetail = new ClientAnchorDetail(colNumber,
	                        colNumber, pictureWidthCoordinates);
	            }
	            // If the user has chosen to overlay both rows and columns or just
	            // to expand ONLY the size of the rows, then calculate how to lay
	            // the image out across one or more columns.
	            else if ((resizeBehaviour == AddDimensionedImage.OVERLAY_ROW_AND_COLUMN) ||
	                     (resizeBehaviour == AddDimensionedImage.EXPAND_ROW)) {
	                colClientAnchorDetail = this.calculateColumnLocation(sheet,
	                        colNumber, reqImageWidthMM);
	            }
	        }
	        // If the column is wider than the image.
	        else {
	            if(sheet instanceof HSSFSheet) {
	                // Mow many co-ordinate positions are there per millimetre?
	                colCoordinatesPerMM = ConvertImageUnits.TOTAL_COLUMN_COORDINATE_POSITIONS /
	                    colWidthMM;
	                // Given the width of the image, what should be it's co-ordinate?
	                pictureWidthCoordinates = (int)(reqImageWidthMM * colCoordinatesPerMM);
	            }
	            else {
	                pictureWidthCoordinates = (int)reqImageWidthMM *
	                        AddDimensionedImage.EMU_PER_MM;
	            }
	            colClientAnchorDetail = new ClientAnchorDetail(colNumber,
	                    colNumber, pictureWidthCoordinates);
	        }
	        return(colClientAnchorDetail);
	    }
	
	    /**
498	     * Determines whether the sheets row should be re-sized to accomodate
499	     * the image, adjusts the rows height if necessary and creates then
500	     * returns a ClientAnchorDetail object that facilitates construction of
501	     * a ClientAnchor that will fix the image on the sheet and establish
502	     * it's size.
503	     *
504	     * @param sheet A reference to the sheet that will 'contain' the image.
505	     * @param rowNumber A primitive int that contains the index number of a
506	     *                  row on the sheet.
507	     * @param reqImageHeightMM A primitive double that contains the required
508	     *                         height of the image in millimetres
509	     * @param resizeBehaviour A primitive int whose value will indicate how the
510	     *                        height of the row should be adjusted if the
511	     *                        required height of the image is greater than the
512	     *                        height of the row.
513	     * @return An instance of the ClientAnchorDetail class that will contain
514	     *         the index number of the row containing the cell whose top
515	     *         left hand corner also defines the top left hand corner of the
516	     *         image, the index number of the row containing the cell whose
517	     *         top left hand corner also defines the bottom right hand
518	     *         corner of the image and an inset that determines how far the
519	     *         bottom edge of the image can protrude into the next (lower)
520	     *         row - expressed as a specific number of coordinate positions.
521	     */
	    private ClientAnchorDetail fitImageToRows(Sheet sheet, int rowNumber,
	            double reqImageHeightMM, int resizeBehaviour) {
	        Row row = null;
	        double rowHeightMM = 0.0D;
	        double rowCoordinatesPerMM = 0.0D;
	        int pictureHeightCoordinates = 0;
	        ClientAnchorDetail rowClientAnchorDetail = null;
	
	        // Get the row and it's height
	        row = sheet.getRow(rowNumber);
	        if(row == null) {
	            // Create row if it does not exist.
	            row = sheet.createRow(rowNumber);
	        }
	
	        // Get the row's height in millimetres
	        rowHeightMM = row.getHeightInPoints() / ConvertImageUnits.POINTS_PER_MILLIMETRE;
	
	        // Check that the row's height will accomodate the image at the required
	        // dimensions. If the height of the row is LESS than the required height
	        // of the image, decide how the application should respond - resize the
	        // row or overlay the image across a series of rows.
	        if(rowHeightMM < reqImageHeightMM) {
	            if((resizeBehaviour == AddDimensionedImage.EXPAND_ROW) ||
	               (resizeBehaviour == AddDimensionedImage.EXPAND_ROW_AND_COLUMN)) {
	                row.setHeightInPoints((float)(reqImageHeightMM *
	                        ConvertImageUnits.POINTS_PER_MILLIMETRE));
                 if(sheet instanceof HSSFSheet) {                    
	                    rowHeightMM = reqImageHeightMM;
	                    rowCoordinatesPerMM = ConvertImageUnits.TOTAL_ROW_COORDINATE_POSITIONS /
	                        rowHeightMM;
	                    pictureHeightCoordinates = (int)(reqImageHeightMM *
	                            rowCoordinatesPerMM);
	                }
	                else {
	                    pictureHeightCoordinates = (int)(reqImageHeightMM *
	                    		AddDimensionedImage.EMU_PER_MM);
	                }
	                rowClientAnchorDetail = new ClientAnchorDetail(rowNumber,
	                        rowNumber, pictureHeightCoordinates);
	            }
	            // If the user has chosen to overlay both rows and columns or just
	            // to expand ONLY the size of the columns, then calculate how to lay
	            // the image out ver one or more rows.
	            else if((resizeBehaviour == AddDimensionedImage.OVERLAY_ROW_AND_COLUMN) ||
	                    (resizeBehaviour == AddDimensionedImage.EXPAND_COLUMN)) {
	                rowClientAnchorDetail = this.calculateRowLocation(sheet,
	                        rowNumber, reqImageHeightMM);
	            }
	        }
	        // Else, if the image is smaller than the space available
	        else {
	            if(sheet instanceof HSSFSheet) {
	                rowCoordinatesPerMM = ConvertImageUnits.TOTAL_ROW_COORDINATE_POSITIONS /
	                    rowHeightMM;
	                pictureHeightCoordinates = (int)(reqImageHeightMM * rowCoordinatesPerMM);
	            }
	            else {
	                pictureHeightCoordinates = (int)(reqImageHeightMM *
	                        AddDimensionedImage.EMU_PER_MM);
	            }
	            rowClientAnchorDetail = new ClientAnchorDetail(rowNumber,
	                        rowNumber, pictureHeightCoordinates);
	        }
	        return(rowClientAnchorDetail);
	    }
	
	    /**
590	     * If the image is to overlie more than one column, calculations need to be
591	     * performed to determine how many columns and whether the image will
592	     * overlie just a part of one column in order to be presented at the
593	     * required size.
594	     *
595	     * @param sheet The sheet that will 'contain' the image.
596	     * @param startingColumn A primitive int whose value is the index of the
597	     *                       column that contains the cell whose top left hand
598	     *                       corner should be aligned with the top left hand
599	     *                       corner of the image.
600	     * @param reqImageWidthMM A primitive double whose value will indicate the
601	     *                        required width of the image in millimetres.
602	     * @return An instance of the ClientAnchorDetail class that will contain
603	     *         the index number of the column containing the cell whose top
604	     *         left hand corner also defines the top left hand corner of the
605	     *         image, the index number column containing the cell whose top
606	     *         left hand corner also defines the bottom right hand corner of
607	     *         the image and an inset that determines how far the right hand
608	     *         edge of the image can protrude into the next column - expressed
609	     *         as a specific number of coordinate positions.
610	     */
	    private ClientAnchorDetail calculateColumnLocation(Sheet sheet,
	                                                       int startingColumn,
	                                                       double reqImageWidthMM) {
	        ClientAnchorDetail anchorDetail = null;
	        double totalWidthMM = 0.0D;
	        double colWidthMM = 0.0D;
	        double overlapMM = 0.0D;
	        double coordinatePositionsPerMM = 0.0D;
	        int toColumn = startingColumn;
	        int inset = 0;
	
	        // Calculate how many columns the image will have to
	        // span in order to be presented at the required size.
	        while(totalWidthMM < reqImageWidthMM) {
	            colWidthMM = ConvertImageUnits.widthUnits2Millimetres(
	                    (short)(sheet.getColumnWidth(toColumn)));
	            // Note use of the cell border width constant. Testing with an image
	            // declared to fit exactly into one column demonstrated that it's
	            // width was greater than the width of the column the POI returned.
	            // Further, this difference was a constant value that I am assuming
	            // related to the cell's borders. Either way, that difference needs
	            // to be allowed for in this calculation.
	            totalWidthMM += (colWidthMM + ConvertImageUnits.CELL_BORDER_WIDTH_MILLIMETRES);
	            toColumn++;
	        }
	        // De-crement by one the last column value.
	        toColumn--;
	        // Highly unlikely that this will be true but, if the width of a series
	        // of columns is exactly equal to the required width of the image, then
	        // simply build a ClientAnchorDetail object with an inset equal to the
	        // total number of co-ordinate positions available in a column, a
	        // from column co-ordinate (top left hand corner) equal to the value
	        // of the startingColumn parameter and a to column co-ordinate equal
	        // to the toColumn variable.
	        //
	        // Convert both values to ints to perform the test.
	        if((int)totalWidthMM == (int)reqImageWidthMM) {
	            // A problem could occur if the image is sized to fit into one or
	            // more columns. If that occurs, the value in the toColumn variable
	            // will be in error. To overcome this, there are two options, to
	            // ibcrement the toColumn variable's value by one or to pass the
	            // total number of co-ordinate positions to the third paramater
	            // of the ClientAnchorDetail constructor. For no sepcific reason,
	            // the latter option is used below.
	            if(sheet instanceof HSSFSheet) {
	                anchorDetail = new ClientAnchorDetail(startingColumn,
	                    toColumn, ConvertImageUnits.TOTAL_COLUMN_COORDINATE_POSITIONS);
	            }
	            else {
	                anchorDetail = new ClientAnchorDetail(startingColumn,
	                    toColumn, (int)reqImageWidthMM * AddDimensionedImage.EMU_PER_MM);
	            }
	        }
	        // In this case, the image will overlap part of another column and it is
	        // necessary to calculate just how much - this will become the inset
	        // for the ClientAnchorDetail object.
	        else {
	            // Firstly, claculate how much of the image should overlap into
	            // the next column.
	            overlapMM = reqImageWidthMM - (totalWidthMM - colWidthMM);
	
	            // When the required size is very close indded to the column size,
	            // the calcaulation above can produce a negative value. To prevent
	            // problems occuring in later caculations, this is simply removed
	            // be setting the overlapMM value to zero.
	            if(overlapMM < 0) {
	                overlapMM = 0.0D;
	            }
	
	            if(sheet instanceof HSSFSheet) {
	                // Next, from the columns width, calculate how many co-ordinate
	                // positons there are per millimetre
	                coordinatePositionsPerMM = ConvertImageUnits.TOTAL_COLUMN_COORDINATE_POSITIONS /
	                    colWidthMM;
	                // From this figure, determine how many co-ordinat positions to
	                // inset the left hand or bottom edge of the image.
	                inset = (int)(coordinatePositionsPerMM * overlapMM);
	            }
	            else {
	                inset = (int)overlapMM * AddDimensionedImage.EMU_PER_MM;
	            }
	
	            // Now create the ClientAnchorDetail object, setting the from and to
	            // columns and the inset.
	            anchorDetail = new ClientAnchorDetail(startingColumn, toColumn, inset);
	        }
	        return(anchorDetail);
	    }
	
	    /**
701	     * If the image is to overlie more than one rows, calculations need to be
702	     * performed to determine how many rows and whether the image will
703	     * overlie just a part of one row in order to be presented at the
704	     * required size.
705	     *
706	     * @param sheet The sheet that will 'contain' the image.
707	     * @param startingRow A primitive int whose value is the index of the row
708	     *                    that contains the cell whose top left hand corner
709	     *                    should be aligned with the top left hand corner of
710	     *                    the image.
711	     * @param reqImageHeightMM A primitive double whose value will indicate the
712	     *                         required height of the image in millimetres.
713	     * @return An instance of the ClientAnchorDetail class that will contain
714	     *         the index number of the row containing the cell whose top
715	     *         left hand corner also defines the top left hand corner of the
716	     *         image, the index number of the row containing the cell whose top
717	     *         left hand corner also defines the bottom right hand corner of
718	     *         the image and an inset that determines how far the bottom edge
719	     *         can protrude into the next (lower) row - expressed as a specific
720	     *         number of co-ordinate positions.
721	     */
	    private ClientAnchorDetail calculateRowLocation(Sheet sheet,
	            int startingRow, double reqImageHeightMM) {
	        ClientAnchorDetail clientAnchorDetail = null;
	        Row row = null;
	        double rowHeightMM = 0.0D;
	        double totalRowHeightMM = 0.0D;
	        double overlapMM = 0.0D;
	        double rowCoordinatesPerMM = 0.0D;
	        int toRow = startingRow;
	        int inset = 0;
	
	        // Step through the rows in the sheet and accumulate a total of their
	        // heights.
	        while(totalRowHeightMM < reqImageHeightMM) {
	            row = sheet.getRow(toRow);
	            // Note, if the row does not already exist on the sheet then create
	            // it here.
	            if(row == null) {
	                row = sheet.createRow(toRow);
	            }
	            // Get the row's height in millimetres and add to the running total.
	            rowHeightMM = row.getHeightInPoints() /
	                    ConvertImageUnits.POINTS_PER_MILLIMETRE;
	            totalRowHeightMM += rowHeightMM;
	            toRow++;
	        }
	        // Owing to the way the loop above works, the rowNumber will have been
	        // incremented one row too far. Undo that here.
	        toRow--;
	        // Check to see whether the image should occupy an exact number of
	        // rows. If so, build the ClientAnchorDetail record to point
	        // to those rows and with an inset of the total number of co-ordinate
	        // position in the row.
	        //
	        // To overcome problems that can occur with comparing double values for
	        // equality, cast both to int(s) to truncate the value; VERY crude and
	        // I do not really like it!!
	        if((int)totalRowHeightMM == (int)reqImageHeightMM) {
	            if(sheet instanceof HSSFSheet) {
	                clientAnchorDetail = new ClientAnchorDetail(startingRow, toRow,
	                    ConvertImageUnits.TOTAL_ROW_COORDINATE_POSITIONS);
	            }
	            else {
	                clientAnchorDetail = new ClientAnchorDetail(startingRow, toRow,
	                    (int)reqImageHeightMM * AddDimensionedImage.EMU_PER_MM);
	            }
	        }
	        else {
	            // Calculate how far the image will project into the next row. Note
	            // that the height of the last row assessed is subtracted from the
	            // total height of all rows assessed so far.
	            overlapMM = reqImageHeightMM - (totalRowHeightMM - rowHeightMM);
	
	            // To prevent an exception being thrown when the required width of
	            // the image is very close indeed to the column size.
	            if(overlapMM < 0) {
	                overlapMM = 0.0D;
	            }
	
	            if(sheet instanceof HSSFSheet) {
	                rowCoordinatesPerMM = ConvertImageUnits.TOTAL_ROW_COORDINATE_POSITIONS /
	                    rowHeightMM;
	                inset = (int)(overlapMM * rowCoordinatesPerMM);
	            }
	            else {
	                inset = (int)overlapMM * AddDimensionedImage.EMU_PER_MM;
	            }
	            clientAnchorDetail = new ClientAnchorDetail(startingRow,
	                        toRow, inset);
	        }
	        return(clientAnchorDetail);
	    }
	
	    /**
	     * The main entry point to the program. It contains code that demonstrates
797	     * one way to use the program.
798	     *
799	     * Note, the code is not restricted to use on new workbooks only. If an
800	     * image is to be inserted into an existing workbook. just open that
801	     * workbook, gat a reference to a sheet and pass that;
802	     *
803	     *      AddDimensionedImage addImage = new AddDimensionedImage();
804	     *
805	     *      File file = new File("....... Existing Workbook .......");
806	     *      FileInputStream fis = new FileInputStream(file);
807	     *      Workbook workbook = new HSSFWorkbook(fis);
808	     *      HSSFSheet sheet = workbook.getSheetAt(0);
809	     *      addImage.addImageToSheet("C3", sheet, "image.jpg", 30, 20,
810	     *          AddDimensionedImage.EXPAND.ROW);
811	     *
812	     * @param args the command line arguments
813	     */
	    public static void main(String[] args) {
	        String imageFile = null;
	        String outputFile = null;
	        FileOutputStream fos = null;
	        Workbook workbook = null;
	        Sheet sheet = null;
	        try {
	                if(args.length < 2){
	                        System.err.println("Usage: AddDimensionedImage imageFile outputFile");
	                        return;
	                }
	                workbook = new HSSFWorkbook();   // OR XSSFWorkbook
	                sheet = workbook.createSheet("Picture Test");
	                imageFile = args[0];
	                outputFile = args[1];
	                new AddDimensionedImage().addImageToSheet("B5", sheet, sheet.createDrawingPatriarch(),
	                        new File(imageFile).toURI().toURL(), 100, 40,
	                        AddDimensionedImage.EXPAND_ROW_AND_COLUMN);
	                fos = new FileOutputStream(outputFile);
	            workbook.write(fos);
	        }
	        catch(FileNotFoundException fnfEx) {
	            System.out.println("Caught an: " + fnfEx.getClass().getName());
	            System.out.println("Message: " + fnfEx.getMessage());
	            System.out.println("Stacktrace follows...........");
	            fnfEx.printStackTrace(System.out);
	        }
	        catch(IOException ioEx) {
	            System.out.println("Caught an: " + ioEx.getClass().getName());
	            System.out.println("Message: " + ioEx.getMessage());
	            System.out.println("Stacktrace follows...........");
	            ioEx.printStackTrace(System.out);
	        }
	        finally {
	            if(fos != null) {
	                try {
	                    fos.close();
	                    fos = null;
	                }
	                catch(IOException ioEx) {
	                    // I G N O R E
	                }
	            }
	        }
	    }
	
	    /**
861	     * The HSSFClientAnchor class accepts eight arguments. In order, these are;
862	     *
863	     *      * How far the left hand edge of the image is inset from the left hand
864	     *      edge of the cell
865	     *      * How far the top edge of the image is inset from the top of the cell
866	     *      * How far the right hand edge of the image is inset from the left
867	     *      hand edge of the cell
868	     *      * How far the bottom edge of the image is inset from the top of the
869	     *      cell.
870	     *      * Together, arguments five and six determine the column and row
871	     *      coordinates of the cell whose top left hand corner will be aligned
872	     *      with the images top left hand corner.
873	     *      * Together, arguments seven and eight determine the column and row
874	     *      coordinates of the cell whose top left hand corner will be aligned
875	     *      with the images bottom right hand corner.
876	     *
877	     * An instance of the ClientAnchorDetail class provides three of the eight
878	     * parameters, one of the coordinates for the images top left hand corner,
879	     * one of the coordinates for the images bottom right hand corner and
880	     * either how far the image should be inset from the top or the left hand
881	     * edge of the cell.
882	     *
883	     * @author Mark Beardsley [msb at apache.org]
884	     * @version 1.00 5th August 2009.
885	     */
	    public class ClientAnchorDetail {
	
	        public int fromIndex = 0;
	        public int toIndex = 0;
	        public int inset = 0;
	
	        /**
893	         * Create a new instance of the ClientAnchorDetail class using the
894	         * following parameters.
895	         *
896	         * @param fromIndex A primitive int that contains one of the
897	         *                  coordinates (row or column index) for the top left
898	         *                  hand corner of the image.
899	         * @param toIndex A primitive int that contains one of the
900	         *                coordinates (row or column index) for the bottom
901	         *                right hand corner of the image.
902	         * @param inset A primitive int that contains a value which indicates
903	         *              how far the image should be inset from the top or the
904	         *              left hand edge of a cell.
905	         */
	        public ClientAnchorDetail(int fromIndex, int toIndex, int inset) {
	            this.fromIndex = fromIndex;
	            this.toIndex = toIndex;
	            this.inset = inset;
	        }
	
	        /**
913	         * Get one of the number of the column or row that contains the cell
914	         * whose top left hand corner will be aligned with the top left hand
915	         * corner of the image.
916	         *
917	         * @return The value - row or column index - for one of the coordinates
918	         *         of the top left hand corner of the image.
919	         */
	        public int getFromIndex() {
	            return(this.fromIndex);
	        }
	
	        /**
925	         * Get one of the number of the column or row that contains the cell
926	         * whose top left hand corner will be aligned with the bottom right hand
927	         * corner of the image.
928	         *
929	         * @return The value - row or column index - for one of the coordinates
930	         *         of the bottom right hand corner of the image.
931	         */
	        public int getToIndex() {
	            return(this.toIndex);
	        }
	
	        /**
937	         * Get the images offset from the edge of a cell.
938	         *
939	         * @return How far either the right hand or bottom edge of the image is
940	         *         inset from the left hand or top edge of a cell.
941	         */
	        public int getInset() {
	            return(this.inset);
	        }
	    }
	
	    /**
948	     * Utility methods used to convert Excels character based column and row
949	     * size measurements into pixels and/or millimetres. The class also contains
950	     * various constants that are required in other calculations.
951	     *
952	     * @author xio[darjino@hotmail.com]
953	     * @version 1.01 30th July 2009.
954	     *      Added by Mark Beardsley [msb at apache.org].
955	     *          Additional constants.
956	     *          widthUnits2Millimetres() and millimetres2Units() methods.
957	     */
	    public static class ConvertImageUnits {
	
	        // Each cell conatins a fixed number of co-ordinate points; this number
	        // does not vary with row height or column width or with font. These two
	        // constants are defined below.
	        public static final int TOTAL_COLUMN_COORDINATE_POSITIONS = 1023; // MB
	        public static final int TOTAL_ROW_COORDINATE_POSITIONS = 255;     // MB
	        // The resoultion of an image can be expressed as a specific number
	        // of pixels per inch. Displays and printers differ but 96 pixels per
	        // inch is an acceptable standard to beging with.
	        public static final int PIXELS_PER_INCH = 96;                     // MB
	        // Cnstants that defines how many pixels and points there are in a
	        // millimetre. These values are required for the conversion algorithm.
	        public static final double PIXELS_PER_MILLIMETRES = 3.78;         // MB
	        public static final double POINTS_PER_MILLIMETRE = 2.83;          // MB
	        // The column width returned by HSSF and the width of a picture when
	        // positioned to exactly cover one cell are different by almost exactly
	        // 2mm - give or take rounding errors. This constant allows that
	        // additional amount to be accounted for when calculating how many
	        // celles the image ought to overlie.
	        public static final double CELL_BORDER_WIDTH_MILLIMETRES = 2.0D;  // MB
	        public static final short EXCEL_COLUMN_WIDTH_FACTOR = 256;
	        public static final int UNIT_OFFSET_LENGTH = 7;
	        public static final int[] UNIT_OFFSET_MAP = new int[]
	            { 0, 36, 73, 109, 146, 182, 219 };
	
	        /**
985	        * pixel units to excel width units(units of 1/256th of a character width)
986	        * @param pxs
987	        * @return
988	        */
	        public static short pixel2WidthUnits(int pxs) {
	            short widthUnits = (short) (EXCEL_COLUMN_WIDTH_FACTOR *
	                    (pxs / UNIT_OFFSET_LENGTH));
	            widthUnits += UNIT_OFFSET_MAP[(pxs % UNIT_OFFSET_LENGTH)];
	            return widthUnits;
	        }
	
	        /**
997	         * excel width units(units of 1/256th of a character width) to pixel
998	         * units.
999	         *
1000	         * @param widthUnits
1001	         * @return
1002	         */
	        public static int widthUnits2Pixel(short widthUnits) {
	            int pixels = (widthUnits / EXCEL_COLUMN_WIDTH_FACTOR)
	                    * UNIT_OFFSET_LENGTH;
	            int offsetWidthUnits = widthUnits % EXCEL_COLUMN_WIDTH_FACTOR;
	            pixels += Math.round(offsetWidthUnits /
	                    ((float) EXCEL_COLUMN_WIDTH_FACTOR / UNIT_OFFSET_LENGTH));
	            return pixels;
	        }
	
	        /**
1013	         * Convert Excels width units into millimetres.
1014	         *
1015	         * @param widthUnits The width of the column or the height of the
1016	         *                   row in Excels units.
1017	         * @return A primitive double that contains the columns width or rows
1018	         *         height in millimetres.
1019	         */
	        public static double widthUnits2Millimetres(short widthUnits) {
            return(ConvertImageUnits.widthUnits2Pixel(widthUnits) /
	                   ConvertImageUnits.PIXELS_PER_MILLIMETRES);
	        }
	
	        /**
1026	         * Convert into millimetres Excels width units..
1027	         *
1028	         * @param millimetres A primitive double that contains the columns
1029	         *                    width or rows height in millimetres.
1030	         * @return A primitive int that contains the columns width or rows
1031	         *         height in Excels units.
1032	         */
	        public static int millimetres2WidthUnits(double millimetres) {
	            return(ConvertImageUnits.pixel2WidthUnits((int)(millimetres *
	                    ConvertImageUnits.PIXELS_PER_MILLIMETRES)));
	        }
        
	        public static int pointsToPixels(double points) {
	                return (int) Math.round(points / 72D * PIXELS_PER_INCH);
	        }
	        
	        public static double pointsToMillimeters(double points) {
	                return points / 72D * 25.4;
	        }
	    }
	}